public class Main{

	public static void main(String[] args){

		String string1 = "<h2>UberJava Driver Dispatcher</h2>\n<h3>Doug here is your next fare:</h3>\n<p>\nRide #1544510358<br/>\n<b>Rider: Al Madrigal</b><br/>\n3 people<br/>\nGoing FROM Fresno to Sacramento<br/>\nFare is $67.49<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=1544510358\">https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=1544510358</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=1544510358\"/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=1544510358</a><br/>\nThen we'll let you know how Al Madrigal rated you.\n</p>\n";
		String string2 ="<h2>UberJava Driver Dispatcher</h2>\n<h3>Prateek here is your next fare:</h3>\n<p>\nRide #15225102A6[UberJavaX Premium]<br/>\n<b>Rider: Pierre Salinger</b><br/>\n2 people<br/>\nGoing FROM San Francisco to Sacramento<br/>\nSURGE PRICING IN EFFECT: Fare is $53.10<br/>\n</p>\n<p>\nNote distance, time and toll information is available at\n<a href=\"distance.cgi?rideNumber=15225102A6\">https://cs.usfca.edu/~dhalperin/distance.cgi?rideNumber=15225102A6</a>\n</p>\n<p>\nLet us know you've completed the trip by reporting to:\n<a href=\"rating.cgi?rideNumber=15225102A6\"/>https://cs.usfca.edu/~dhalperin/rating.cgi?rideNumber=15225102A6</a><br/>\nThen we'll let you know how Pierre Salinger rated you.\n</p>";
		
		Parser test = new Parser(string2);

		System.out.println(test.getRideNumber());
		System.out.println(test.getRiderName());
		System.out.println(test.getFare());
		System.out.println(test.getPeople());
		System.out.println(test.getFrom());
		System.out.println(test.getTo());
		System.out.println(test.getIsSurgePricing());
		System.out.println(test.getIsDouble());
		System.out.println(test.getIsPreminum());
	
	}

}