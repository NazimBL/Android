private UsbSerialInterface.UsbReadCallback mCallback = new UsbSerialInterface.UsbReadCallback() {
        @Override
        public void onReceivedData(byte[] arg0) {
            try {

                byte[] rec=new byte[2];
                for(int i=0;i<2;i++){
                    rec[i]=arg0[i];
                }
                ByteBuffer wrapped = ByteBuffer.wrap(rec);
                short m=wrapped.getShort();

                if (mHandler != null)
                    mHandler.obtainMessage(MESSAGE_FROM_SERIAL_PORT,m+"\n").sendToTarget();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


 send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edit.getText().toString().equals("")) {
                    String data = edit.getText().toString();
                    int windSpeed= Integer.parseInt(data);

                    byte[] rec=new byte[2];
                    rec[0]=(byte)(windSpeed / 256);
                    rec[1]=(byte)(windSpeed % 256);
                    if (usbService != null) { // if UsbService was correctly binded, Send data
                        //usbService.write(data.getBytes());
                        usbService.write(rec);
                    }else Toast.makeText(MainActivity.this,"usb service is null",Toast.LENGTH_SHORT).show();
                }
            }
        });
