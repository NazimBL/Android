        new Thread(new Runnable() {
            @Override
            public void run() {
                Socket socket=null;
                try {

                    socket = new Socket("10.121.85.208",8888);
                    String message=edit.getText().toString();
                    PrintWriter writer =new PrintWriter(socket.getOutputStream());
                    writer.write(message);
                    writer.flush();
                    writer.close();
                    
                }catch (IOException e){
                   e.printStackTrace();
                }
            }
         }).start();
