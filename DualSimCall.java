public final static String simSlotName[] = {
            "extra_asus_dial_use_dualsim",
            "com.android.phone.extra.slot",
            "slot",
            "simslot",
            "sim_slot",
            "subscription",
            "Subscription",
            "phone",
            "com.android.phone.DialingMode",
            "simSlot",
            "slot_id",
            "simId",
            "simnum",
            "phone_type",
            "slotId",
            "slotIdx"
    };
    
     @RequiresApi(api = Build.VERSION_CODES.M)
     void dualCall(Context context, int simselected, String number) {

        TelecomManager telecomManager = (TelecomManager) context.getSystemService(Context.TELECOM_SERVICE);
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            Log.d("Nazim","call permission denied");
            ActivityCompat.requestPermissions((Activity) context, new String[] { Manifest.permission.READ_PHONE_STATE,Manifest.permission.CALL_PHONE},4);
        }else  Log.d("Nazim","call permission approved");

        List<PhoneAccountHandle> phoneAccountHandleList = telecomManager.getCallCapablePhoneAccounts();

        Intent intent = new Intent(Intent.ACTION_CALL).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + number));
        intent.putExtra("com.android.phone.force.slot", true);
        intent.putExtra("Cdma_Supp", true);
        
            for (String s : simSlotName)
                intent.putExtra(s, simselected); //0 or 1 according to sim.......

            if (phoneAccountHandleList != null && phoneAccountHandleList.size() > 0)
                intent.putExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE", phoneAccountHandleList.get(simselected));

            context.startActivity(intent);    
    }
