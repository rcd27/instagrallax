package com.githib.rcd27.instagrallax;

import android.app.SearchManager;
import android.content.Context;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.SearchEvent;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    private static final String[] SUGGESTIONS = {
            "Вариант#1", "Вариант#2", "Вариант#3",
            "Не варинат", "Кукуруза", "арбуз",
            "Мыло", "верёвка", "КОмод", "стОл"
    };
    private SimpleCursorAdapter cursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /* presenter block*/
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
                // newText -> presenter
                updateAdapter(newText);
                return true;
            }
        });

        return true;
    }

    //TODO вынести в интерфейс
    private void updateAdapter(@NonNull String query) {
        /* presenter block*/
        final MatrixCursor mc = new MatrixCursor(new String[]{BaseColumns._ID, "userName"});
        for (int i = 0; i < SUGGESTIONS.length; i++) {
            if (SUGGESTIONS[i].toLowerCase().startsWith(query.toLowerCase())) {
                mc.addRow(new Object[]{i,SUGGESTIONS[i]});
            }
        }
        // cursorAdapter <-♦ presenter
        cursorAdapter.changeCursor(mc);
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
}
