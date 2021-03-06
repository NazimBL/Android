   //init graphs , wdigets and app features ( USB/FullScreen )
    private void init(){

        //init USB manager and start on BOOT intent Broadcast Receiver
        setContentView(R.layout.activity_main);
        IntentFilter inf=new IntentFilter(Intent.ACTION_MAIN);
        inf.addAction(Intent.ACTION_BOOT_COMPLETED);
        receiver=new StartMyServiceAtBootReceiver();
        registerReceiver(receiver,inf);
        
        manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        inf.addAction(ACTION_USB_ATTACHED);
        

        //init widgets
        textView=(TextView)findViewById(R.id.text_id);
        serie1 = new LineGraphSeries<>();
        serie1.setColor(Color.parseColor("#EB9114"));
        line = new LineGraphSeries<>();
        point1=new PointsGraphSeries<>();
        point2=new PointsGraphSeries<>();
        graph=(GraphView)findViewById(R.id.graph);
        
        a=(ImageButton)findViewById(R.id.a);
        b=(ImageButton)findViewById(R.id.b);
        a.setBackgroundColor(Color.TRANSPARENT);
        b.setBackgroundColor(Color.TRANSPARENT);

        tp=Typeface.createFromAsset(getAssets(),"timeburnerbold.ttf");
        textView.setTypeface(tp);
        mControlsView = findViewById(R.id.layout);

        // init graphs data points
        DataPoint[] dataPoint=new DataPoint[SIZE];
        for(int i=0;i<SIZE;i++)dataPoint[i]=new DataPoint(i,CurrentFunction(i,1000,25));
        
        //method to draw/update 2 simultaneous graphs
        graphsInit(dataPoint);
        
        //method that draws critical points at the x,y specified
        CriticalPointUpdate(10,CurrentFunction(10,1000,25));


        //enable full screen mode
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        //setting graph labels
        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    if(value!=0)return super.formatLabel(value, isValueX) + " V";
                    else return "0";
                } else {
                    // show currency for y values
                    if(value!=0)return super.formatLabel(value, isValueX) + " W";
                    else return "";
                }
            }
        });

        graph.getSecondScale().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    if(value!=0)return super.formatLabel(value, isValueX) + " V";
                    else return "0";
                } else {
                    // show currency for y values
                    if(value!=0)return super.formatLabel(value, isValueX) + " A";
                    else return "";
                }
            }
        });
    }
    
      void graphsInit(DataPoint[] IVdata){

        //remove previous graph draws
        graph.removeAllSeries();
        graph.getSecondScale().removeAllSeries();
        DataPoint[] PVdata=new DataPoint[SIZE];

        for(int i=0;i<SIZE;i++)PVdata[i]=new DataPoint(IVdata[i].getX(),IVdata[i].getX()*IVdata[i].getY());


        line=new LineGraphSeries<>(PVdata);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(80);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(40);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        graph.addSeries(line);


        serie1=new LineGraphSeries<>(IVdata);
        serie1.setColor(Color.BLACK);

        graph.getSecondScale().setMinY(0);
        graph.getSecondScale().setMaxY(3);
        graph.getSecondScale().addSeries(serie1);
        graph.getSecondScale().addSeries(point2);

        line.setTitle("P,V Curve");
        serie1.setTitle("I,V Curve");

        //graph.getViewport().setDrawBorder(true);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setBackgroundColor(Color.TRANSPARENT);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);

    }
