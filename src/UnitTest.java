
public class UnitTest {
	
  	public static final String msg1 = "T depaapo zy l Nzcy Qwlvp lyo yzh T lx l Npcplw Vtwwpc";
	public static final String msg2 = "Kvoh rc mci hvwby opcih hvs aouwqoz mszzck ibwqcfb kvc robqsg cb hvs fowbpck";
	public static final String msg3 = "Ol euax igtuk oy yzaiq ot g zxkk cozn znk nkgjromnzy ut nuc sgte vgtigqky juky oz zgqk zu mkz zu znk suut";
	
	
	
	public static void main(String[] args) {
		
		Decoder cracker=new Decoder(msg1,"english.txt");
		cracker.decode();
		System.out.println("Encrypted Text: "+cracker.getCipherText());
		System.out.println("Decrypted Text: "+ cracker.getPlainText());
	}
	
}
