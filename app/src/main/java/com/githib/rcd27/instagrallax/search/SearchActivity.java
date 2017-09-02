package com.githib.rcd27.instagrallax.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.user.UserActivity;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private SearchContract.Presenter presenter;

    private SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        presenter = new SearchPresenter(this);
        //FIXME: "userName" фигурирует в презентере. Перенести создание адаптера и курсора в одно место.
        cursorAdapter = new SimpleCursorAdapter(
                SearchActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                null,
                // Колонка, которую показываем в списке
                new String[]{"userName"},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        cursorAdapter.setFilterQueryProvider(query -> presenter.getCursorFor((String) query));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconified(false);
        searchView.setSuggestionsAdapter(cursorAdapter);

        searchView.setOnSuggestionListener(new SearchView.OnSuggestionListener() {
            @Override
            public boolean onSuggestionSelect(int position) {
                Toast.makeText(getApplicationContext(),
                        "Suggestion has been selected",
                        Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onSuggestionClick(int position) {
                CursorAdapter ca = searchView.getSuggestionsAdapter();
                Cursor cursor = ca.getCursor();
                cursor.moveToPosition(position);

                showUser(cursor.getInt(cursor.getColumnIndex("instId")));
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.goToUserIfExists(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public void showError(@NonNull String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUser(int userId) {
        Intent goToUserActivity = new Intent(getApplicationContext(), UserActivity.class);
        goToUserActivity.putExtra("USER_ID", userId);
        startActivity(goToUserActivity);
    }

    @Override
    protected void onStop() {
        //  see: https://developer.android.com/reference/android/support/v4/widget/CursorAdapter.html#FLAG_REGISTER_CONTENT_OBSERVER
        if (null != cursorAdapter && null != cursorAdapter.getCursor()) {
            cursorAdapter.getCursor().close();
        }
        super.onStop();
    }
}
