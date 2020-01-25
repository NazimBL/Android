public class MainActivity extends AppCompatActivity {

private Button scanButton;
public static TextView creditText;


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);
        
         scanButton=(Button)findViewById(R.id.scan_button_id);
         creditText=(TextView)findViewById(R.id.credit_text_id);

            scanButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainPanel.this,ScanActivity.class));
                }
            });
    }
}   
    
