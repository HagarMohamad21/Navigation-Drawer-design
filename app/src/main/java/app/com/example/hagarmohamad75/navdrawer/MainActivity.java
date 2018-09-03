package app.com.example.hagarmohamad75.navdrawer;


import android.app.ActivityOptions;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout Dlayout;
    ActionBarDrawerToggle bToggle;
    ListView NavMenu;
    int Icons[];
    int[] IconName;
    int[] IsMenue;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dlayout= (DrawerLayout) findViewById(R.id.Dlayout);
        NavMenu= (ListView) findViewById(R.id.navList);
        Icons= new int[]{R.drawable.ic_house_outline,
                R.drawable.ic_user,
                R.drawable.ic_event,
                R.drawable.ic_fav,
                R.drawable.ic_mail
                ,R.drawable.ic_phone_call,
                R.drawable.ic_feedback,R.drawable.ic_settings,0};
        IconName= new int[]{R.string.home,R.string.profile,R.string.events,R.string.fav,
                R.string.inbox,R.string.call,R.string.feedback,R.string.settings,R.string.dummy};
        IsMenue=new int[]{1,1,1,1,2,1,1,1,0};
        bToggle=new ActionBarDrawerToggle(this,Dlayout,R.string.open,R.string.close);
        Dlayout.addDrawerListener(bToggle);
        bToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        customAdapter=new CustomAdapter(Icons,IconName,this,IsMenue);
        NavMenu.setAdapter(customAdapter);}



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(bToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
