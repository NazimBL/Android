 Long startTime;

        startTime=System.nanoTime();

        new Thread(new Runnable() {
            @Override public void run() {
                
                while (true){
                if((System.nanoTime()-startTime)/1000000> 10000){
                  Log.d("Nazim","10 SECONDS");
                  startActivity(new Intent(MainActivity.this,WifiNetworkTest.class));
                  break;
                 }
                }
               }
        }).start();
