public void shareIt(){
        try {
            //  final PackageManager pm = getPackageManager();

            // List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

//                        for (ApplicationInfo packageInfo : packages) {
//
//                            Toast.makeText(MainActivity.this, "Installed package :" + packageInfo.packageName, Toast.LENGTH_SHORT).show();
//                            Toast.makeText(MainActivity.this, "Launch Activity :" + pm.getLaunchIntentForPackage(packageInfo.packageName), Toast.LENGTH_SHORT).show();
//
//
//                        }
           // Intent i = getPackageManager().getLaunchIntentForPackage("com.example.dell.serial");
            Intent i = getPackageManager().getLaunchIntentForPackage("SHAREit");
            startActivity(i);

        } catch (Exception e) {
            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
