package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /* Exercise 1
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */
		// ### EXAMPLE:
		int birdsOnABranch = 4;
		int birdsThatFlyAway = 1;
		int birdsRemaining = birdsOnABranch - birdsThatFlyAway;

        /* Exercise 2
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */
		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /* Exercise 3
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */

		int numberOfRaccoons = 3;
		int numberOfRaccoonsHome = 2;
		int numberOfRaccoonsLeft = numberOfRaccoons - numberOfRaccoonsHome;

        /* Exercise 4
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */

		int flowers = 5;
		int bees = 3;
		int differenceBetweenBeesAndFlowers = flowers - bees;

        /* Exercise 5
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */

		int lonelyPigeon = 1;
		int otherPigeon = 1;
		int pigeons = lonelyPigeon + otherPigeon;

        /* Exercise 6
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */

		int numberOfOwlsOnFence = 3;
		int numberOfAdditionalOwls = 2;
		int totalOwls = numberOfOwlsOnFence + numberOfAdditionalOwls;

        /* Exercise 7
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */

		int numberOfBeaversWorkingOnHome = 2;
		int numberOfBeaversOnASwim = 1;
		numberOfBeaversWorkingOnHome = numberOfBeaversWorkingOnHome - numberOfBeaversOnASwim;

        /* Exercise 8
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */

		int numberOfToucansSittingOnTree = 2;
		int numberofToucansJoined = 1;
		int totalToucans = numberOfToucansSittingOnTree + numberofToucansJoined;

        /* Exercise 9
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */

		int squirrels = 4;
		int nuts = 2;
		int squirrelsComparedToNuts = squirrels - nuts;

        /* Exercise 10
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */

		//could be a constant since coin values will not change
		double quarter = 0.25;
		double dime = 0.10;
		double nickel = 0.05;
		double totalMoneyFound = quarter + dime + (2 * nickel);

        /* Exercise 11
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */

		int numberOfMuffinsBrier = 18;
		int numberofMuffinsMacAdams = 20;
		int numberofMuffinsFlannery = 17;
		int totalFirstGradeMuffinCount = numberOfMuffinsBrier + numberofMuffinsMacAdams + numberofMuffinsFlannery;

        /* Exercise 12
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */

		double priceOfYoyo = 0.24;
		double priceOfWhistle = 0.14;
		double totalCostOfToys = priceOfYoyo + priceOfWhistle;

        /* Exercise 13
        13. Mrs. Hilt made 5 Rice Krispies Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */

		int numberOfLargeMarshmallows = 8;
		int numberOfSmallMarshmallows = 10;
		int totalNumberOfMarshmallows = numberOfLargeMarshmallows + numberOfSmallMarshmallows;

        /* Exercise 14
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */

		int amountOfSnowHilt = 29;
		int amountOfSnowBrecknock = 17;
		int differenceInSnowfall = amountOfSnowHilt - amountOfSnowBrecknock;

        /* Exercise 15
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2.50 on a pencil
        case. How much money does she have left?
        */

		double totalAmountOfMoneyHilt = 10.0;
		double costOfToyTruck = 3.0;
		double costOfPencilCase = 2.5;
		double moneyLeft = totalAmountOfMoneyHilt - (costOfToyTruck + costOfPencilCase);

        /* Exercise 16
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */

		int marblesInCollection = 16;
		int marblesLost = 7;
		int marblesRemaining = marblesInCollection - marblesLost;

        /* Exercise 17
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */

		int currentSeashells = 19;
		int goalSeashells = 25;
		int seashellsNeeded = goalSeashells - currentSeashells;

        /* Exercise 18
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */

		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;

        /* Exercise 19
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */

		int booksOnShelf = 38;
		int booksMartaAdded = 10;
		int booksOnShelfAfter = booksOnShelf + booksMartaAdded;

        /* Exercise 20
        20. A bee has 6 legs. How many legs do 8 bees have?
        */

		int numberOfBeeLegs = 6;
		int numberOfBees = 8;
		int totalNumberOfBeeLegs = numberOfBeeLegs * numberOfBees;

        /* Exercise 21
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */

		double costOfIceCreamCone = 0.99;
		int numberOfIceCreamCones = 2;
		double totalCostOfIceCream = costOfIceCreamCone * numberOfIceCreamCones;

        /* Exercise 22
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */

		int numberOfRocksToComplete = 125;
		int numberOfRocksCurrently = 64;
		int numberOfRocksNeeded = numberOfRocksToComplete - numberOfRocksCurrently;

        /* Exercise 23
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */

		int numberOfMarbles = 38;
		int numberOfLostMarbles = 15;
		int numberOfMarblesLeft = numberOfMarbles - numberOfLostMarbles;

        /* Exercise 24
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */

		int distanceToConcert = 78;
		int distanceDriven = 32;
		int distanceLeft = distanceToConcert - distanceDriven;

        /* Exercise 25
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time (in minutes) did she spend shoveling snow?
        */

		int timeSpentShovelingSnowMorning = 90;
		int timeSpentShovelingSnowAfternoon = 45;
		int totalTimeSpentShovelingSnow = timeSpentShovelingSnowMorning + timeSpentShovelingSnowAfternoon;

        /* Exercise 26
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */

		int numberOfHotDogs = 6;
		double costOfHotDogs = 0.5;
		double totalCost = numberOfHotDogs * costOfHotDogs;

        /* Exercise 27
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */

		//int div fine since she cannot go over 50, so better to have rounded-down answer
		int totalMoneyToSpend = 50;
		int costOfPencil = 7;
		int pencilsHiltCanBuy = totalMoneyToSpend / costOfPencil;

        /* Exercise 28
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */

		int butterfliesSeen = 33;
		int orangeButterflies = 20;
		int redButterflies = butterfliesSeen - orangeButterflies;

        /* Exercise 29
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */

		double moneyGiven = 1.0;
		double costOfCandy = 0.54;
		double changeGiven = moneyGiven - costOfCandy;

        /* Exercise 30
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */

		int numberOfTreesCurrently = 13;
		int numberOfTreesPlanted = 12;
		int totalNumberOfTrees = numberOfTreesCurrently + numberOfTreesPlanted;

        /* Exercise 31
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */

		int daysTilGrandma = 2;
		int hoursInDay = 24;
		int hoursTilGrandma = daysTilGrandma * hoursInDay;

        /* Exercise 32
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */

		int numberOfCousins = 4;
		int numberOfPiecesOfGumPerCousin = 5;
		int numberOfPiecesOfGumNeeded = numberOfPiecesOfGumPerCousin * numberOfCousins;

        /* Exercise 33
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */

		double moneyDanHas = 3.0;
		double candyBarCost = 1.0;
		double moneyRemaining = moneyDanHas - candyBarCost;

        /* Exercise 34
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */

		int numberOfBoats = 5;
		int numberOfPeopleOnBoats = 3;
		int totalNumberOfPeople = numberOfBoats * numberOfPeopleOnBoats;

        /* Exercise 35
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */

		int startingNumberOfLegos = 380;
		int legosLost = 57;
		int legosLeft = startingNumberOfLegos - legosLost;

        /* Exercise 36
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */

		int bakedMuffins = 35;
		int muffinGoal = 83;
		int muffinsLeftToMake = muffinGoal - bakedMuffins;

        /* Exercise 37
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */

		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int differenceInCrayons = willyCrayons - lucyCrayons;

        /* Exercise 38
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */

		int numberOfStickersPerPage = 10;
		int numberOfPages = 22;
		int totalNumberOfStickers = numberOfStickersPerPage * numberOfPages;

        /* Exercise 39
        39. There are 100 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */

		double totalCupcakes = 100.0;
		int numberOfChildren = 8;
		double cupcakesPerChild = totalCupcakes / numberOfChildren;

        /* Exercise 40
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies, how many
        cookies will not be placed in a jar?
        */

		int gingerbreadCookiesMade = 47;
		int glassJarCapacity = 6;
		int cookiesNotPlacedInJar = gingerbreadCookiesMade % glassJarCapacity;

        /* Exercise 41
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received an equal number of croissants,
        how many will be left with Marian?
        */

		int numberOfCroissants = 59;
		int numberOfNeighbours = 8;
		int leftoverCroissants = numberOfCroissants % numberOfNeighbours;

        /* Exercise 42
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */

		int numberOfCookiesPerTray = 12;
		int totalNumberOfCookies = 276;
		int numberOfTraysNeeded = (totalNumberOfCookies / numberOfCookiesPerTray);

        /* Exercise 43
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */

		//480 divisible by 12 --> int div is fine
		int numberOfPretzels = 480;
		int servingSize = 12;
		int numberOfServingsMade = numberOfPretzels / servingSize;

        /* Exercise 44
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */

		int lemonCupcakesMade = 53;
		int lemonCupcakesForgotten = 2;
		int lemonCupCakesBrought = lemonCupcakesMade - lemonCupcakesForgotten;
		int numberOfLemonCupcakeBoxes = lemonCupCakesBrought / 3;

        /* Exercise 45
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */

		int numberOfCarrotSticks =74;
		int numberOfPeopleServed = 12;
		int carrotsLeftUneaten = numberOfCarrotSticks % numberOfPeopleServed;

        /* Exercise 46
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */

		int numberOfTeddyBears = 98;
		int teddyBearsPerShelf = 7;
		int numberOfShelvesNeeded = numberOfTeddyBears / teddyBearsPerShelf;

        /* Exercise 47
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */

		int numberOfPictures = 480;
		int picturesPerAlbum = 20;
		int numberOfAlbumsNeeded = numberOfPictures / picturesPerAlbum;

        /* Exercise 48
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */

		int numberOfCards = 94;
		int boxCapacity = 8;
		int numberOfBoxesNeeded = numberOfCards / boxCapacity;
		int numberOfCardsInUnfilledBox = numberOfCards % boxCapacity;

        /* Exercise 49
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */

		int numberOfBooks = 210;
		int numberOfShelves = 10;
		int booksPerShelf = numberOfBooks / numberOfShelves;

        /* Exercise 50
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */

		double numberOfCroissantsMade = 17.0;
		int numberOfGuests = 7;
		double croissantsPerGuest = numberOfCroissantsMade / numberOfGuests;

	    /* Exercise 51
	    51. Bill and Jill are house painters. Bill can paint a standard room in 2.15 hours, while Jill averages
	    1.90 hours. How long will it take the two painters working together to paint 5 standard rooms?
	    Hint: Calculate the rate at which each painter can complete a room (rooms / hour), combine those rates, 
	    and then divide the total number of rooms to be painted by the combined rate.
	    */

		double averageRatePerRoomBill = 1/2.15;
		double averageRatePerRoomJill = 1/1.90;
		int numberOfRooms = 5;
		double averageCombinedRate = averageRatePerRoomBill + averageRatePerRoomJill;
		double durationOfTimeToPaintRooms = numberOfRooms / averageCombinedRate;

	    /* Exercise 52
	    52. Create and assign variables to hold a first name, last name, and middle initial. Using concatenation,
		build an additional variable to hold the full name in the order of last name, first name, middle initial. The
		last and first names should be separated by a comma followed by a space, and the middle initial must end
		with a period. Use "Grace", "Hopper, and "B" for the first name, last name, and middle initial.
		Example: "John", "Smith, "D" —> "Smith, John D."
	    */

		String firstName = "Grace";
		String lastName = "Hopper";
		char middleInitial = 'B';
		String fullName = lastName + ", " + firstName + " " + middleInitial + ".";

	    /* Exercise 53
	    53. The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
	    What percentage of the trip as a whole number has been completed?
	    */

		double distanceNewYorkToChicago = 800.0;
		int distanceTravelled = 537;
		double distanceCompleted = 100 * (distanceTravelled / distanceNewYorkToChicago);
		int percentageTravelled = (int) (distanceCompleted);

	}

}
