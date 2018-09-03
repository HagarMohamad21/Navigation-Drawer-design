package app.com.example.hagarmohamad75.navdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int Icons[];
    int[] IconName;
    Context mContext;
    int[] IsMenu;
    public final int IsMenue=0;
    public final int IsNotMenue=1;
    public final int Inbox=2;
    public CustomAdapter(int[]Icons,int[]IconName,Context mContext,int[] IsMenu){
        this.Icons=Icons;
        this.IconName=IconName;
        this.mContext=mContext;
        this.IsMenu=IsMenu;
    }
    public CustomAdapter(){

    }
    @Override
    public int getCount() {
        return Icons.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            if(getItemViewType(i)==IsMenue){
                view= LayoutInflater.from(mContext).inflate(R.layout.list_item,null,false);
            }

            else if(getItemViewType(i)==IsNotMenue){
                view= LayoutInflater.from(mContext).inflate(R.layout.list_tail_item,null,false);
            }else if(getItemViewType(i)==Inbox){
                view= LayoutInflater.from(mContext).inflate(R.layout.inbox_layout,null,false);
            }
        }
        if(getItemViewType(i)==IsMenue){
            TextView Descrep= (TextView) view.findViewById(R.id.IconDescrep);
            ImageView Icon= (ImageView) view.findViewById(R.id.iconVector);
            Descrep.setText(IconName[i]);
            Icon.setImageResource(Icons[i]);
        }
        else if(getItemViewType(i)==IsNotMenue){
            ImageView Myschool,Add,Help,LogOut;
            TextView DashBoard,MyshoolText,AddText,HelpText,LogOutText;
            Myschool= (ImageView) view.findViewById(R.id.Myschool);
            MyshoolText= (TextView) view.findViewById(R.id.MyschoolText);
            Add=(ImageView) view.findViewById(R.id.AddBtn);
            AddText= (TextView) view.findViewById(R.id.Addtxt);
            Help=(ImageView) view.findViewById(R.id.helpBtn);
            HelpText= (TextView) view.findViewById(R.id.HelpTxt);
            LogOut=(ImageView) view.findViewById(R.id.LogOutBtn);
            LogOutText= (TextView) view.findViewById(R.id.LogOutTxt);
            DashBoard= (TextView) view.findViewById(R.id.dashBoard);
        }
       else if(getItemViewType(i)==Inbox){
            TextView Descrep= (TextView) view.findViewById(R.id.inboxDes);
            ImageView Icon= (ImageView) view.findViewById(R.id.inboxIcon);
            TextView Badge=(TextView) view.findViewById(R.id.inboxBadge);
            Descrep.setText(IconName[i]);
            Icon.setImageResource(Icons[i]);
        }

        return view; }
    @Override
    public int getItemViewType(int position) {
        if(IsMenu[position]==0){
            return IsNotMenue;
        }
        else if(IsMenu[position]==2){
            return Inbox;
        }
        else{return  IsMenue;}
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
}