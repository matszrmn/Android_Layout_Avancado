package br.com.moduloavancado.ui.activity.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.moduloavancado.R;
import br.com.moduloavancado.dao.TravelDao;
import br.com.moduloavancado.model.Travel;
import br.com.moduloavancado.util.DrawableUtil;
import br.com.moduloavancado.util.Formatter;

public class TravelListAdapter extends BaseAdapter {

    private final Context context;
    private final List<Travel> travels;
    private final TravelDao travelDao;

    public TravelListAdapter(Context context, List<Travel> travelList) {
        this.context = context;
        this.travelDao = new TravelDao();

        if (travelList != null) {
            travels = new ArrayList<>(travelList);
        } else {
            travels = new ArrayList<>();
        }
    }

    @Override
    public int getCount() {
        return travels.size();
    }

    @Override
    public Object getItem(int position) {
        return travels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        }
        Travel travel = travels.get(position);
        Drawable drawable = DrawableUtil.getDrawable(travel, context);

        ((ImageView) convertView.findViewById(R.id.activity_main_item_image1)).setImageDrawable(drawable);
        ((TextView) convertView.findViewById(R.id.activity_main_item_title1)).setText(travel.getTitle());
        ((TextView) convertView.findViewById(R.id.activity_main_item_days1)).setText(Formatter.formatDay(travel.getDays()));
        ((TextView) convertView.findViewById(R.id.activity_main_item_value1)).setText(Formatter.formatValue(travel.getValue()));
        return convertView;
    }

    public void remove(Travel travel) {
        if (travelDao.remove(travel.getId())) {
            travels.remove(travel);
            notifyDataSetChanged();
        }
    }

    public void refreshAdapter(List<Travel> travelList) {
        travels.clear();
        travels.addAll(travelList);
        notifyDataSetChanged();
    }
}
