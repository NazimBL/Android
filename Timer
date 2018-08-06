
Timer autoupdate;

public void ref(final long del){
        autoupdate = new Timer();
        autoupdate.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                              //WRITE TIMER TASK
                              //Tcp();
                              //setSensorValue;
                              //graphSensorUpdate();

                             } catch (Exception e) {
                                Log.d("Nazim","Main error"+e.toString());
                             }
                    }
                });
            }
        }, 0, del);
    }
    
     @Override
    protected void onResume() {
        super.onResume();
        try {
           ref(refreshTime);
        }catch (Exception e){
            Log.d("Nazim","Timer exception"+e.toString());
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        autoupdate.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        try {
           ref(refreshTime);
        }catch (Exception e){
            Log.d("Nazim","Timer exception"+e.toString());
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        autoupdate.cancel();

    }
    
    
