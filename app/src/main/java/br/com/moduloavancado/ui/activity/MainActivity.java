package br.com.moduloavancado.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.moduloavancado.R;
import br.com.moduloavancado.dao.TravelDao;
import br.com.moduloavancado.model.Travel;
import br.com.moduloavancado.ui.activity.adapter.TravelListAdapter;

public class MainActivity extends AppCompatActivity {

    public static final String TITLE = "Pacotes";

    private ListView listView;
    private TravelListAdapter travelListAdapter;
    private TravelDao travelDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTitle();
        initDao();
        initListView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        travelListAdapter.refreshAdapter(travelDao.getAll());
    }

    private void initDao() {
        travelDao = new TravelDao();
    }

    private void initTitle() {
        setTitle(TITLE);
    }

    private void initListView() {
        listView = findViewById(R.id.activity_main_list);
        travelListAdapter = new TravelListAdapter(this, travelDao.getAll());
        listView.setAdapter(travelListAdapter);
        configLongClickRemove();
    }

    private void configLongClickRemove() {
        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            travelListAdapter.remove((Travel) travelListAdapter.getItem(position));
            return true;
        });
    }
}