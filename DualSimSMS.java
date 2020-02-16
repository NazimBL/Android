 public  void sendSMS(Context context,String number,String text,int index){

        try {
           
            SmsManager.getSmsManagerForSubscriptionId (index).sendTextMessage(number, null, smsText, null, null);
            
        } catch (Exception e) {
            Toast.makeText(context, "Sms not Send :" +e.toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
}
