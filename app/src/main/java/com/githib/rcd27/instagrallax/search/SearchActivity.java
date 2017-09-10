package com.githib.rcd27.instagrallax.search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.MagnettoApp;
import com.githib.rcd27.instagrallax.R;
import com.githib.rcd27.instagrallax.dagger.SearchModule;
import com.githib.rcd27.instagrallax.user.UserActivity;

import java.util.List;

import javax.inject.Inject;

import static com.githib.rcd27.instagrallax.user.UserActivity.USER_ID;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    public static final String CURSOR_USER_NAME = "USER_NAME";
    public static final String CURSOR_INST_ID = "INST_ID";

    @Inject
    public SearchContract.Presenter presenter;

    private SearchManager searchManager;
    private SearchView searchView;

    @Inject
    public SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        MagnettoApp.getInstance().getAppComponent().plus(new SearchModule(this, SearchActivity.this))
                .inject(this);

        searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconified(false);
        searchView.setSuggestionsAdapter(cursorAdapter);
        searchView.setOnSuggestionListener(new SearchViewSuggestionListener());
        searchView.setOnQueryTextListener(new SearchViewQueryListener());

        return true;
    }

    @Override
    public void showError(@NonNull String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUser(long userId) {
        Intent goToUserActivity = new Intent(getApplicationContext(), UserActivity.class);
        goToUserActivity.putExtra(USER_ID, userId);
        startActivity(goToUserActivity);
    }

    @Override
    public void showSuggestions(List<SearchUser> users) {
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID,
                CURSOR_INST_ID, CURSOR_USER_NAME});
        for (int i = 0; i < users.size(); i++) {
            SearchUser currentUser = users.get(i);
            mc.addRow(new Object[]{i, currentUser.getId(), currentUser.getFullName()});
        }
        cursorAdapter.changeCursor(mc);
    }

    @Override
    protected void onStop() {
        //  see: https://developer.android.com/reference/android/support/v4/widget/CursorAdapter.html#FLAG_REGISTER_CONTENT_OBSERVER
        if (null != cursorAdapter && null != cursorAdapter.getCursor()) {
            cursorAdapter.getCursor().close();
        }
        super.onStop();
    }

    /**
     * Обрабатывает клик на элементе выпадающего списка SearchView
     */
    private class SearchViewSuggestionListener implements SearchView.OnSuggestionListener {

        @Override
        public boolean onSuggestionSelect(int position) {
            return true;
        }

        @Override
        public boolean onSuggestionClick(int position) {
            CursorAdapter ca = searchView.getSuggestionsAdapter();
            Cursor cursor = ca.getCursor();
            cursor.moveToPosition(position);

            showUser(cursor.getLong(cursor.getColumnIndex(CURSOR_INST_ID)));
            return true;
        }
    }

    /**
     * Слушает изменения в TextView поиска.
     */
    private class SearchViewQueryListener implements SearchView.OnQueryTextListener {

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (!newText.isEmpty()) {
                presenter.proceedUserSearch(newText);
            }
            return false;
        }
    }
}
