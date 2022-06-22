package towerdefense;

public class CommandDebugger {
	public boolean checkNewGame(String cmd) {
		return (cmd.equals("new game normal")||cmd.equals("new game hard"));
	}
	public boolean checkStartRound(String cmd) {
		return (cmd.equals("start round"));
	}
	public boolean checkCmdNoSpaces(String cmd) {
		return (cmd.equals("skip")||cmd.equals("exit")||cmd.equals("help me"));
	}
	public String[] getInstruction(String cmd, int space) {
		String[] ret = null;
		String instr = cmd.substring(0,space);          //get the string before 1st space
		if(instr.equals("build")) {
			String[] instrArray = new String[3];
			instrArray[0] = instr;
			String Bn = cmd.substring(space+1, space+3);
			if(Bn.equals("B1")||Bn.equals("B2")||Bn.equals("B3"))
				instrArray[1] = Bn;                     //get building number
			else return ret;
			String Bnumber = cmd.substring(space+4);    //get location
			try{
				int Bnum=Integer.parseInt(Bnumber);     //make sure the location number is an integer
				if(Bnum>=1 && Bnum<=10) {
					instrArray[2] = Bnumber;
					return instrArray;
				}
				else return ret;
			}
			catch(NumberFormatException e){
				 return ret;
			}
			
		}
		else if(instr.equals("upgrade")) {
			String[] instrArray = new String[3];
			instrArray[0] = instr;
			String loc = cmd.substring(space+1, space+2);
			try{
				int location = Integer.parseInt(loc);   //make sure the location number is an integer
				if(location>=1 && location<=10) {
					instrArray[1] = loc;                //get location
				}
				else return ret;
			}
			catch(NumberFormatException e){
				 return ret;
			}
			String times = cmd.substring(space+3, space+4);
			try{
				Integer.parseInt(times);                //make sure the upgrade number is an integer
				instrArray[2] = times;                  //get upgrade times
				return instrArray;
			}
			catch(NumberFormatException e){
				 return ret;
			}
		}
		else if(instr.equals("destroy")) {
			String[] instrArray = new String[2];
			instrArray[0] = instr;
			String loc = cmd.substring(space+1, space+2);
			try{
				int location = Integer.parseInt(loc);   //make sure the location number is an integer
				if(location>=1 && location<=10) {
					instrArray[1] = loc;                //get location
					return instrArray;
				}
				else return ret;
			}
			catch(NumberFormatException e){
				 return ret;
			}
		}
		else return ret;
	}
}
