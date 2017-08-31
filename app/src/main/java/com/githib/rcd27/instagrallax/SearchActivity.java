package com.githib.rcd27.instagrallax;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.SearchEvent;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconified(false);

        //V#1 FIXME: собственно, говоря, адаптер не отрабатывает.
        searchView.setSuggestionsAdapter(new SimpleCursorAdapter(
                SearchActivity.this,
                R.layout.support_simple_spinner_dropdown_item,
                null,
                new String[]{"USER_ID"},
                new int[]{android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        ));

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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),
                        "Query text has been submitted",
                        Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(),
                        "Query text has been changed",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        return true;
    }

    /**
     * Срабатывает, когда поступил запрос на поиск.
     * @param searchEvent - ну, собственно запрос, надо полагать.
     * @return - ну и возвращает, как всегда, непонятный boolean
     */
    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }
}
