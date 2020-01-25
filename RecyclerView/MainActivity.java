public class MainPanel extends AppCompatActivity {

    EditText phoneNumber;
    RecyclerView recyclerView;
    myRecycleViewAdapter adapter;
   
   public static final int DJEZZY_OFFERS_IMG[]= new int[]{R.drawable.internet_jour,R.drawable.internet_semaine,R.drawable.internet_mois,
            R.drawable.hayla_maxi_jour,R.drawable.hayla_maxi_semaine,R.drawable.hayla_maxi_mois1,R.drawable.hayla_maxi_mois_2,R.drawable.hayla_maxi_mois3 };

    public static final int MOBILIS_OFFERS_IMG[]=new int[]{R.drawable.mob1,R.drawable.mob2,R.drawable.hayla4};
    public static final int NEDJMA_OFFERS_IMG[]=new int[]{R.drawable.oreedo1,R.drawable.oredoo2,R.drawable.ooredoo3};

    public static final String DJEZZY_OFFERS_TXT[]=new String[]{"Internet 24h","Internet 7 Jr","Internet 1 Mois",
         "Hayla Maxi 24h","Hayla Maxi 7 Jr","Hayla Maxi Mois 1","Hayla Maxi Mois 2","Hayla Maxi Mois 3"};

    public static final String MOBILIS_OFFERS_TXT[]=new String[]{"Internet 24h","Internet 7 Jr","Internet 1 Mois"};

    public static final String NEDJMA_OFFERS_TXT[]=new String[]{"Internet 24h","Internet 7 Jr","Internet 1 Mois"};
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_panel);
        Setup();

        phoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.length()>1){
                    MainActivity.myToast(""+s.charAt(1),MainPanel.this);
                    if(s.charAt(1)=='7'){
                        adapter=new myRecycleViewAdapter(MainPanel.this,Data.DJEZZY_OFFERS_TXT,Data.DJEZZY_OFFERS_IMG);                   
                    }
                    else if(s.charAt(1)=='5') {
                        adapter=new myRecycleViewAdapter(MainPanel.this,Data.NEDJMA_OFFERS_TXT,Data.NEDJMA_OFFERS_IMG);
                    
                    }
                    else if(s.charAt(1)=='6'){
                        adapter=new myRecycleViewAdapter(MainPanel.this,Data.MOBILIS_OFFERS_TXT,Data.MOBILIS_OFFERS_IMG);                 
                    }

                    try{
                        recyclerView.setAdapter(adapter);
                    }catch (Exception e){
                        MainActivity.myToast(""+e.toString(),MainPanel.this);
                    }
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

 
    void Setup(){

        //GUI
        phoneNumber=(EditText)findViewById(R.id.phone_id);
        
        recyclerView=(RecyclerView)findViewById(R.id.list_view_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);
        adapter=new myRecycleViewAdapter(this,Data.DJEZZY_OFFERS_TXT,Data.DJEZZY_OFFERS_IMG);
        recyclerView.setAdapter(adapter);      
    }

    public void onClickCalled(String anyValue) {
        // Call another acitivty here and pass some arguments to it.
        MainActivity.myToast(""+anyValue,MainPanel.this);
    }

}
