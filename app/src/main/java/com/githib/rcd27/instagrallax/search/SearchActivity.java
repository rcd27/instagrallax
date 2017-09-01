package com.githib.rcd27.instagrallax.search;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.SearchEvent;
import android.widget.Toast;

import com.githib.rcd27.instagrallax.R;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private SearchContract.Presenter presenter;

    private SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new SearchPresenter(this);
        //FIXME: "userName" фигурирует в презентере. Перенести создание адаптера и курсора в одно место.
        cursorAdapter = new SimpleCursorAdapter(
                SearchActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                null,
                new String[]{"userName"},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
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
                Toast.makeText(getApplicationContext(),
                        "Suggestion has been clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        cursorAdapter.setFilterQueryProvider(query -> presenter.refreshSuggestions((String) query));

        return true;
    }

    /**
     * Срабатывает, когда поступил запрос на поиск.
     *
     * @param searchEvent - ну, собственно запрос, надо полагать.
     * @return - ну и возвращает, как всегда, непонятный boolean
     */
    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }

    @Override
    public void showError(@NonNull String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }
}
