int value =0;
byte rec[2];
int received=0;
int test=276;
void setup() {
  // put your setup code here, to run once:
Serial.begin(115200);
pinMode(13,OUTPUT);

}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()){
  Serial.readBytes(rec,2);
  received=(int)(rec[0]*256);
  received+=rec[1]; 
  if(received==test)digitalWrite(13,1);
  else digitalWrite(13,0);
  
 }
value=analogRead(A0);
Serial.write(highByte(value));
Serial.write(lowByte(value));

delay(1000);

}
