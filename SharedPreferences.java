import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    ImageView img1,img2;
    Button b1,b2;
    int hp1=50,hp2=50;
    TextView t1,t2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    b1=(Button)findViewById(R.id.b1);
    b2=(Button)findViewById(R.id.b2);


b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        t2.setText(""+hp2--);
    }
});
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.setText(""+hp1--);
            }
        });

        checkHealth1();
        checkHealth2();

        t1=(TextView)findViewById(R.id.hp1);
        t2=(TextView)findViewById(R.id.hp2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_settings:
                break;

            case R.id.sv:
                SharedPreferences save = getSharedPreferences("save", 0);
                SharedPreferences.Editor editor = save.edit();
                editor.putInt("hp1", hp1).putInt("hp2", hp2);
                editor.apply();
                Toast.makeText(MainActivity.this, "Saving game ...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ld:
                SharedPreferences load = getSharedPreferences("save", 0);
                hp1 = load.getInt("hp1", 0);
                hp2 = load.getInt("hp2", 0);
                t2.setText("" + hp2);
                t1.setText("" + hp1);
                checkHealth2();
                checkHealth1();
                Toast.makeText(this,"loading....", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
            return super.onOptionsItemSelected(item);
        }
  public void checkHealth1(){
img1=(ImageView)findViewById(R.id.img1);
if(hp1<25) {

    img1.setImageResource(R.drawable.irondeath2);
}
  else img1.setImageResource(R.drawable.ironman1);
  }

    public void checkHealth2(){
        img2=(ImageView)findViewById(R.id.img2);
if(hp2<25) {img2.setImageResource(R.drawable.death);}
  else img2.setImageResource(R.drawable.cs);

    }
}
