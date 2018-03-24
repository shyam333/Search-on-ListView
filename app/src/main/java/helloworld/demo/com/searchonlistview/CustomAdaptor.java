package helloworld.demo.com.searchonlistview;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.*;

import android.graphics.drawable.*;
import android.widget.*;
import android.content.*;
import android.view.*;


public class CustomAdaptor extends BaseAdapter {

    Context context;
    List<Model> itemModelList = new ArrayList<>();

    public CustomAdaptor(Context context){//}, List<Model> itemModelList) {
        this.context = context;
        this.itemModelList = itemModelList;
    }

    @Override
    public int getCount() {
        return itemModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void addItem(Model model) {
        itemModelList.add(model);
        notifyDataSetChanged();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.img_players = (ImageView) convertView.findViewById(R.id.img_players);
            viewHolder.playername = (TextView) convertView.findViewById(R.id.player_name);
            viewHolder.imgRemove = (ImageView) convertView.findViewById(R.id.imgRemove);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Model m = itemModelList.get(position);
        Drawable drawable = context.getResources().getDrawable(R.drawable.img1);
        viewHolder.playername.setText(m.getName());
        viewHolder.img_players.setImageDrawable(drawable);
        viewHolder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemModelList.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
}

class ViewHolder {
    TextView playername;
    ImageView imgRemove;
    ImageView img_players;

}