 public void write_toFile() {

        File file;

        try {

            //File sdcard = Environment.getExternalStorageDirectory();
            //File sdcard=
            //File dir = new File(sdcard.getAbsolutePath()+"/Nazim");
            //to write on sd card File dir=new File("/mnt"+path);
            File dir = new File("/mnt/usbhost1");
            dir.mkdir();

            file = new File(dir, "text.txt");
            String msg = "";
            if (finalResults != null) {
                for (int i = 0; i < finalResults.length; i++) {
                    msg += finalResults[i] + ",";
                }
                Calendar c = Calendar.getInstance();
                CharSequence s = DateFormat.format("yyyy-MM-dd hh:mm:ss", c.getTime());
                msg += s;
                msg+="\r\n";

            }

            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                // true = append file
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);

                bw.write(msg);
                bw.newLine();

            } catch (IOException e) {

                e.printStackTrace();

            } finally {

                try {

                    if (bw != null)
                        bw.close();

                    if (fw != null)
                        fw.close();

                } catch (IOException ex) {

                    ex.printStackTrace();

                }
            }

            }catch(Exception e){
                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_SHORT).show();

          }
    }
