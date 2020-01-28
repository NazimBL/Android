//signal quality drawable
    public static final int SIGNAL_IMG[]=new int[]{R.drawable.signal_empty,R.drawable.signal_bad,
                                                   R.drawable.signal_good,R.drawable.signal_full};
    private ImageView signalIcon;
    
private void setupSignalStrength() {

        final TelephonyManager manager = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        signalIcon=(ImageView)findViewById(R.id.signal_icon_id);
        PhoneStateListener phoneListener;
        
        phoneListener = new PhoneStateListener() {
            @Override
            public void onSignalStrengthsChanged(SignalStrength signalStrength) {
                if (manager.getNetworkOperator().equals("")) {
                    signalIcon.setVisibility(View.GONE);
                } else {
                    signalIcon.setVisibility(View.VISIBLE);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    
                        Log.d("Nazim", "signal level= " + signalStrength.getLevel());                 
                        if (signalStrength.getLevel()>=3)signalIcon.setImageResource(SIGNAL_IMG[3]);
                        else signalIcon.setImageResource(SIGNAL_IMG[signalStrength.getLevel()]);

                    } else signalIcon.setImageResource(SIGNAL_IMG[3]);
                }
               }
            };

        manager.listen(phoneListener,PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
        }
