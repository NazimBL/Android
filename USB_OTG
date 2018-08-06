    public static UsbManager manager;
    public static UsbInterface usbInterface;
    public static UsbEndpoint outEnd,inEnd;
    public static byte code=0;
    public static UsbDevice stmUsb;
    public static boolean usbConnected=false;
    public static UsbDeviceConnection Myconnection;

    public static final String ACTION_USB_ATTACHED  = "android.hardware.usb.action.USB_DEVICE_ATTACHED";
    StartMyServiceAtBootReceiver receiver;

    public static byte[] bytes;
    public static byte[] received=new byte[64];
    public static short[] vRead=new short[32];
    public static short[] iRead=new short[32];
    public static short[] IVs=new short[2];
    
    private void init(){

        //init USB manager
        setContentView(R.layout.activity_main);
        IntentFilter inf=new IntentFilter(Intent.ACTION_MAIN);
        registerReceiver(receiver,inf);

        manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        inf.addAction(ACTION_USB_ATTACHED);

    }
    
    //check available usb devices
    boolean checkUsb() throws FileNotFoundException {

        HashMap<String, UsbDevice> deviceList = manager.getDeviceList();
        Iterator<UsbDevice> deviceIterator = deviceList.values().iterator();
        boolean tag=false;

        while ((deviceIterator.hasNext())) {
            UsbDevice device = deviceIterator.next();

            if(device.getDeviceName()!=null) {
                ///looking for usb device with this vendor id
                if(device.getVendorId()==4660)
                    usbInterface = MyUsb.findAdbInterface(device,MainActivity.this);

                if (usbInterface != null){
                    tag = true;
                    stmUsb=device;
                }
                else tag = false;

            }else Toast.makeText(MainActivity.this,"no device available ",Toast.LENGTH_LONG).show();
        }
        usbConnected=tag;
        return tag;
    }
    
    public static byte[] first=new byte[64];
    public static byte[] second=new byte[64];

    public static UsbInterface findAdbInterface(UsbDevice device, Context context) {

        int count = device.getInterfaceCount();
        // Toast.makeText(context,"count : "+count,Toast.LENGTH_SHORT).show();
        for (int i = 0; i < count; i++) {
            //     Toast.makeText(context,"interface loop : "+i,Toast.LENGTH_SHORT).show();
            UsbInterface intf = device.getInterface(i);
            return intf;

        }
        return null;
    }
    
    public static void manageEndpoints(Context contenxt){

        outEnd=null;
        inEnd=null;

        for (int i = 0; i < usbInterface.getEndpointCount(); i++) {
            UsbEndpoint ep = usbInterface.getEndpoint(i);

            if (ep.getDirection() == UsbConstants.USB_DIR_OUT) {
                outEnd = ep;
                //Toast.makeText(contenxt,"out end point get direction  : "+MainActivity.outEnd.getDirection(),Toast.LENGTH_LONG).show();
            } else {
                inEnd = ep;
                //Toast.makeText(contenxt,"in end point get direction  : "+inEnd.getDirection(),Toast.LENGTH_LONG).show();
            }

        }

    }
    
     public static  void usbCom(UsbDevice device,Context context){

        manageEndpoints(context);


        if(outEnd!=null && device!=null && usbInterface!=null) {

            PendingIntent pendingIntent=PendingIntent.getBroadcast(context,0,
                    new Intent(UsbManager.EXTRA_PERMISSION_GRANTED),0);
            MainActivity.manager.requestPermission(device,pendingIntent);
            UsbDeviceConnection connection=null;
            if(MainActivity.manager.hasPermission(device)) {
                connection=MainActivity.manager.openDevice(device);
                MainActivity.Myconnection=connection;
            }
            else  MainActivity.myToast("permission denied",context);

            try {
                if (connection != null) {
                    if (connection.claimInterface(usbInterface,true)) {
                        try {
                       
                            int transfer=0;
                            bytes ="KO".getBytes();
                            transfer = connection.bulkTransfer(outEnd,bytes,bytes.length,0);
                            int reception1=connection.bulkTransfer(inEnd,first,first.length,0);
                            IVs=fetchReception(first);
                         

                        }catch (Exception e){
                            Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
                        }

                    } else Toast.makeText(context,"couldnt claim interface",Toast.LENGTH_SHORT).show();

                } else {
                    connection.close();
                    Toast.makeText(context,"couldnt open connection  ",Toast.LENGTH_SHORT).show();
                }
            }catch (Exception e){
                
                Toast.makeText(context,e.toString(),Toast.LENGTH_SHORT).show();
            }

        }else  Toast.makeText(context,"no end point found",Toast.LENGTH_SHORT).show();


    }
    public class USB_BroadcastReceiver  extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        if (action.equalsIgnoreCase(MainActivity.ACTION_USB_ATTACHED)) {
            Toast.makeText(context, "USB DETECTED", Toast.LENGTH_SHORT).show();
        }
    }
}

    
