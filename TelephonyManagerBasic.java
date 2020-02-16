publiv void TelephonyManagerInfo(){ 
 
 TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
 if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
 
           // if user doesn't got permission ask for it first
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.MODIFY_PHONE_STATE, Manifest.permission.ACCESS_COARSE_LOCATION,
                }, 0);      
        }
        
        String IMEINumber = tm.getDeviceId();
        String SIMSerialNumber = tm.getSimSerialNumber();
        String SIMCountryISO = tm.getSimCountryIso();

        String info = "Phone Details:\n";

        info += "\n IMEI Number:" + IMEINumber;
        info += "\n Sim Serial Number:" + SIMSerialNumber;

        info += "\n SIM Country ISO:" + SIMCountryISO;
        info += "\n Sim Network operator:" + tm.getSimOperatorName();
        info += "\n sim number :" + tm.getPhoneCount();

        textView.setText(info);
        }
