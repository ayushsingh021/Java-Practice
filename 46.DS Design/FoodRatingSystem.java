// Design a food rating system that can do the following:

// Modify the rating of a food item listed in the system.
// Return the highest-rated food item for a type of cuisine in the system.
// Implement the FoodRatings class:

// FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
// foods[i] is the name of the ith food,
// cuisines[i] is the type of cuisine of the ith food, and
// ratings[i] is the initial rating of the ith food.
// void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
// String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
// Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.

 

// Example 1:

// Input
// ["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
// [[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
// Output
// [null, "kimchi", "ramen", null, "sushi", null, "ramen"]

// Explanation
// FoodRatings foodRatings = new FoodRatings(["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]);
// foodRatings.highestRated("korean"); // return "kimchi"
//                                     // "kimchi" is the highest rated korean food with a rating of 9.
// foodRatings.highestRated("japanese"); // return "ramen"
//                                       // "ramen" is the highest rated japanese food with a rating of 14.
// foodRatings.changeRating("sushi", 16); // "sushi" now has a rating of 16.
// foodRatings.highestRated("japanese"); // return "sushi"
//                                       // "sushi" is the highest rated japanese food with a rating of 16.
// foodRatings.changeRating("ramen", 16); // "ramen" now has a rating of 16.
// foodRatings.highestRated("japanese"); // return "ramen"
//                                       // Both "sushi" and "ramen" have a rating of 16.
//                                       // However, "ramen" is lexicographically smaller than "sushi".



class FoodRatings {


    //Planning the datastructures
    HashMap<String , Integer> food_rating = new HashMap<>();
    HashMap<String, String>  food_cuisine  = new HashMap<>();
    HashMap<String , TreeSet<Pair<Integer,String>>> cuisine_rating_food = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for(int i = 0 ; i < n ; i++){
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            food_rating.put(food , rating);
            food_cuisine .put( food,cuisine );
            cuisine_rating_food.computeIfAbsent(cuisine , k -> new TreeSet<>((a,b) -> 
            {
                int compareRatings = Integer.compare(a.getKey() , b.getKey());
                if(compareRatings == 0 ){
                    return a.getValue().compareTo(b.getValue());
                }
                return compareRatings;
            })).add(new Pair(-rating, food));

        }
    }
    
    public void changeRating(String food, int newRating) {
        //ye food kaunse cuisine ka hai
        String oldCuisine = food_cuisine.get(food);
        TreeSet<Pair<Integer,String>> oldElem =  cuisine_rating_food.get(oldCuisine);
        //muje treeset ke pair me remove bhi karna hoga so req the old val
        Pair<Integer , String> oldPair = new Pair<>(-food_rating.get(food) , food);//val to be removed
        oldElem.remove(oldPair);
        oldElem.add(new Pair<>(-newRating, food)); 
        food_rating.put(food , newRating);
    }
    
    public String highestRated(String cuisine) {
        Pair<Integer, String> highestRated = cuisine_rating_food.get(cuisine).first();
        return highestRated.getValue();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */