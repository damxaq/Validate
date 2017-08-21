package com.damxaq.test;


import org.junit.Assert;
import org.junit.Test;

import com.damxaq.logic.Counter;

public class Tests {

	@Test
	public void testSetValues1() {
		Boolean[] card;
		String[][] cardNumbers;
		Counter counter = new Counter();
		
		cardNumbers = new String[][] {
			{"Visa","4000-0799-2739-8715"},
			{"Visa","5000 0000 1234 5678"},
			{"Visa","40002847193819287"}
			};
		
		card = counter.validate(cardNumbers);
		
		Assert.assertTrue(card[0]);
		Assert.assertFalse(card[1]);
		Assert.assertFalse(card[2]);
	}
	
	@Test
	public void testSetValues2() {
		Boolean[] card;
		String[][] cardNumbers;
		Counter counter = new Counter();
		
		cardNumbers = new String[][] {
			{"Totally Legit Bank","1234-5678-9010-1110"},
			{"Discover Card","622126-103952-1904"}
			};
		
		card = counter.validate(cardNumbers);
		
		Assert.assertFalse(card[0]);
		Assert.assertFalse(card[1]);
	}
	
	@Test
	public void testSetValues3() {
		Boolean[] card;
		String[][] cardNumbers;
		Counter counter = new Counter();
		
		cardNumbers = new String[][] {
			{"MasterCard","5101-9352-1234-4448"}, 
			{"American Express","1234 395478 30498"}, 
			{"American Express","3948 29384 20390"}
			};
		
		card = counter.validate(cardNumbers);
		
		Assert.assertTrue(card[0]);
		Assert.assertFalse(card[1]);
		Assert.assertFalse(card[2]);
	}

	@Test
	public void testSetValues4() {
		Boolean[] card;
		String[][] cardNumbers;
		Counter counter = new Counter();
		
		cardNumbers = new String[][] {
			{"Laser","67 092015 239734 375"}, 
			{"Discover Card","6222117726251007070"}, 
			{"American Express","3409 5938 6306 423"}, 
			{"Discover Card","6532550590530780378"}, 
			{"Discover Card","6473780297817696280"}, 
			{"Discover Card","6221-5677-9688-9380121"}, 
			{"Mafstro","6999015026494127421"}, 
			{"American Express","3444 8403-5097  618"}, 
			{"JCB","35754971514304431"}, 
			{"Discover Card","6011577234761760072"}, 
			{"IntwrPayment","6360027117085856"}, 
			{"Visa","4500878169229"}, 
			{"Maestro","5759877498192"}, 
			{"American Express","3784478855498485"}, 
			{"Laser","6706400840834423296"}, 
			{"InterPayment","6362314651587027854"}, 
			{"Laser","670986429635888356"}, 
			{"Vmsa","4345534207321247794"}, 
			{"Maeatro","640298314199"}, 
			{"Discover Card","62268883925361333717"}, 
			{"MasterCarl","5287531954575574"}, 
			{"Laser","6706022548732739931"}, 
			{"Maestro","67309415708416"}, 
			{"Discover Card","6011943756423338985"}, 
			{"Maestro","56758362217388"}, 
			{"American Express","340373263971731"}, 
			{"Laser","6706001331241425260"}, 
			{"MasterCard","5500097339705857"}, 
		 	{"MasterCard","636652455120115033"}, 
		 	{"DiscovervCard","6011110857304912893"}, 
		 	{"American Express","3475110171130401"}, 
		 	{"Maestro","6233110284741001794"}, 
		 	{"JCB","3548488373370154"}, 
		 	{"Laser","6709633893653330301"}, 
		 	{"Visa","4114977286857622"}, 
		 	{"American Express","376141577195231"}, 
		 	{"Discover Card","6585471921818715"}, 
		 	{"InterPayment","6369239842756856713"}, 
		 	{"JCB","3552810974243113"}, 
		 	{"Laser","6771028143705686"}, 
		 	{"Laser","6706724279444001730"}, 
		 	{"American Express","340512369742708"}, 
		 	{"American Express","63613455647250706"}, 
		 	{"InterPayment","6361657669167748910"}, 
		 	{"MasterCard","5199723170205055"}, 
		 	{"JCB","3560856973003383"}, 
		 	{"JCB","3571176888680163"}, 
		 	{"MasterCard","5334723900506842"}
			};
		
		card = counter.validate(cardNumbers);
		
		Boolean[] expected ={true, true, true, true, true, true, false, true, false, true, false, 
				false, true, false, true, true, true, false, false, false, false, true, true, 
				true, true, true, false, true, false, false, false, true, true, true, true, true, 
				true, true, true, false, true, true, false, true, true, false, true, false};
		
		Assert.assertArrayEquals(expected, card);
	}
	
	@Test
	public void testSetValues5() {
		Boolean[] card;
		String[][] cardNumbers;
		Counter counter = new Counter();
		
		cardNumbers = new String[][] {
			{"JCB","35410338613198823"}, 
			{"Visa","4981092520862764"}, 
			{"Visa","4819  4184-92350"}, 
			{"Laser","3538387202414492"}, 
			{"InterPayment","6368-10400100 2378121"}, 
			{"American Efpress","374657318671836"}, 
			{"JCB","3539 17 87 927 5 3 7 9 8"}, 
			{"Vdsa","4621524940458296152"}, 
			{"American Express","345435744657539"}, 
			{"Mrestro","5016-20-50-0-8-1-512858-8"}, 
			{"JCB","-345923400569-650"}, 
			{"MasterCard","23321101012755716"}, 
			{"Maestro","67379251529952"}, 
			{"Visa"," 5209710602074850"}, 
			{"InterPayment","6369870141342883990"}, 
			{"Laser","67069491660674571"}, 
			{"Maestri","639074222143418"}, 
			{"Maestro","6641120953323"}, 
			{"Maestro","633047943612610"}, 
			{"Maestro","62868503274198"}, 
			{"Visa","4664303698335"}, 
			{"Visa","4130110778954863568"}, 
			{"Visa","42657536792531"}, 
			{"American Express","2555812846969593"}, 
			{"Laser","67097084713302237"}, 
			{"JCB","35371835440442420"}, 
			{"Discover Card","3536241805339576"}, 
			{"American Express","341897336771586"}, 
			{"Laser","5502615546700961"}, 
			{"Discover Card","64795258022225006"}, 
			{"JCB","4773342441027"}, 
			{"Laser","67064613293232406864"}, 
			{"Discover Card","6004952515759546352"}
		};
		
		card = counter.validate(cardNumbers);
		
		Boolean[] expected = {false, false, true, false, true, false, 
				true, false, true, false, false, false, true, false, true, 
				true, false, true, true, true, true, true, false, false, true, false, 
				false, true, false, false, false, false, false};
		
		Assert.assertArrayEquals(expected, card);

	}
}
