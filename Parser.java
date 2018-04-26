import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser{

		//String string1 = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Doug here is your next fare:</h3>\n<p>\nRide #1544510358<br/>\n<b>Rider: Al Madrigal</b><br/>\n3 people<br/>\nGoing FROM Fresno to Sacramento<br/>\nFare is $67.49<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=1544510358\">https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=1544510358</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=1544510358\"/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=1544510358</a><br/>\nThen we'll let you know how Al Madrigal rated you.\n</p>\n";
		String rideNumber = "";
		String riderName = "";
		double fare;
		int people;
		String from = "";
		String to = "";
		boolean isSurgePricing = false;
		boolean isDouble = false;
		boolean isPreminum = false;

	public static void main(String[] args){

		String string1 = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Doug here is your next fare:</h3>\n<p>\nRide #1544510358<br/>\n<b>Rider: Al Madrigal</b><br/>\n3 people<br/>\nGoing FROM Fresno to Sacramento<br/>\nFare is $67.49<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=1544510358\">https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=1544510358</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=1544510358\"/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=1544510358</a><br/>\nThen we'll let you know how Al Madrigal rated you.\n</p>\n";
		Parser test = new Parser(string1);

	}

	
	public Parser(String string1){
		Pattern pattern = Pattern.compile("Ride #(.*){10}?");
		Matcher matcher = pattern.matcher(string1);
		if(matcher.find()){
			//System.out.println(matcher.group(0));
			this.rideNumber = matcher.group(0).substring(matcher.group(0).indexOf("#")+1, 16);
			//System.out.println(rideNumber); 
		}
		pattern = Pattern.compile("Rider: (.*?)<");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.riderName = matcher.group(0).substring(matcher.group(0).indexOf(":")+2,matcher.group(0).indexOf("<"));
			//System.out.println(riderName); 
		}
		pattern = Pattern.compile("Fare (.*?)<");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.fare = Double.parseDouble(matcher.group(0).substring(matcher.group(0).indexOf("$")+1,matcher.group(0).indexOf("<")));
			//System.out.println(fare); 
		}
		pattern = Pattern.compile(">\\n(.*?) people<");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.people = Integer.parseInt(matcher.group(0).substring(matcher.group(0).indexOf("\\d{1}")+3,matcher.group(0).indexOf(" ")));
			//System.out.println(people); 
		}
		pattern = Pattern.compile("FROM (.*?) to");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.from = matcher.group(0).substring(matcher.group(0).indexOf("M")+2,matcher.group(0).indexOf(" to"));
			//System.out.println(from); 
		}
		pattern = Pattern.compile("to (.*?)<");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.to = matcher.group(0).substring(matcher.group(0).indexOf(" ")+1,matcher.group(0).indexOf("<"));
			//System.out.println(to); 
		}
		pattern = Pattern.compile("SURGE PRICING");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.isSurgePricing = true;
		}
		//System.out.println(isSurgePricing);

		pattern = Pattern.compile("DOUBLE SURGE PRICING");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.isDouble = true;
		}
		//System.out.println(isDouble);
		pattern = Pattern.compile("UberJavaX Premium");
		matcher = pattern.matcher(string1);
		if(matcher.find()){
			this.isPreminum = true;
		}
		//System.out.println(isPreminum);
			
		}

		public String getRideNumber(){
			return this.rideNumber;
		}
		public String getRiderName(){
			return this.riderName;
		}
		public double getFare(){
			return this.fare;
		}
		public int getPeople(){
			return this.people;
		}
		public String getFrom(){
			return this.from;
		}
		public String getTo(){
			return this.to;
		}
		public boolean getIsSurgePricing(){
			return this.isSurgePricing;
		}
		public boolean getIsDouble(){
			return this.isDouble;
		}
		public boolean getIsPreminum(){
			return this.isPreminum;
		}



}



