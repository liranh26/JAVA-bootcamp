package streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIntro {

	public static void main(String[] args) {

		simpleMapping_JustAddOneToCreatedStream();
		singleFunctionObjectMapping_extractName();
		multipleFunctionsMapping_extractPriceAndConvertToBigDecimal();
		sumAllPrices_extractPricesChangeToBigDecimalAndReduce();
		rewriteWithForeach();
		countNumberOfElementsWithMapReduce();
		mapReduceTest();
		mapInTermsOfForEach();
	}

	public static void simpleMapping_JustAddOneToCreatedStream() {
		List<Integer> start = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> result = start.stream().map(a -> a + 1).collect(Collectors.toList()); // complete this line - add
																							// one to each value
		System.out.println(result);
	}

	/**
	 * 1) complete function getName so it returns product name
	 */
	public static void singleFunctionObjectMapping_extractName() {
		Function<Product, String> getName = p -> p.name; // Product class is definied at the bottom of this file
		// gets product , return string, the function name is 'getName'
		Stream<String> names = products().map(getName);
		// map sends Product to function and retrieve String
		System.out.println(names.collect(Collectors.toList()));
//      containsExactly("tv","console","mouse","speakers");
	}

	/**
	 * 1) extract price which is String 2) convert price to BigDecimal
	 */
	public static void multipleFunctionsMapping_extractPriceAndConvertToBigDecimal() {
		Function<Product, String> getPrice = p -> p.price;
		Function<String, BigDecimal> toBigDecimal = s -> new BigDecimal(s); // complete this

		Stream<BigDecimal> prices = products().map(getPrice).map(toBigDecimal);

		System.out.println(prices.collect(Collectors.toList()));
//      new BigDecimal("300.0"),new BigDecimal("200.0"),new BigDecimal("20.0"),new BigDecimal("45.5")
	}

	/**
	 * 1) extract price from Product - > String 
	 * 2) convert price to BigDecimal 
	 * 3) sum all prices
	 */
	public static void sumAllPrices_extractPricesChangeToBigDecimalAndReduce() {
		Function<Product, String> getPrice = p -> p.price;
		Function<String, BigDecimal> toBigDecimal = s -> new BigDecimal(s);

		Function<Product, BigDecimal> bigDecimalPrice = getPrice.andThen(toBigDecimal);

		BigDecimal result = products().map(bigDecimalPrice).reduce(new BigDecimal(0), (curr, next) -> curr.add(next));
		System.out.println(result);
//        assertThat(result).isEqualTo(new BigDecimal("565.5"));
	}
	
	
	
	/**
     * 1) write each name to mutable list "names"
     */
    public static void rewriteWithForeach(){
        List<String> names=new LinkedList<>();

        products().forEach(n -> names.add(n.name));
        System.out.println(names);
//        assertThat(names).containsExactly("tv","console","mouse","speakers");
    }
    
    
    /**
     *  1) map every element to one
     *  2) reduce by adding all values
     */
    public static void countNumberOfElementsWithMapReduce() {
        Integer numberOfProducts = products()
                .<Integer>map(p -> 1)
                .reduce(0,(curr, next)-> curr+next);
        System.out.println(numberOfProducts);
//        assertThat(numberOfProducts).isEqualTo(4);
    }
	
    
    /**
     *  don't change test
     *  complete basicMapReduce method which is listed below
     */
    public static void mapReduceTest() {
        List<String> input = Arrays.asList("1", "2", "3","4");
        Function<String,Integer> toInt = Integer::parseInt;
        BinaryOperator<Integer> multiply=(i1,i2)->i1*i2;

        Integer result = basicMapReduce(toInt, multiply, 1, input.stream());
        
        System.out.println(result);
//        assertThat(result).isEqualTo(24);

    }
	
    //Use 'map' on Stream and then 'reduce'
    private static <A,B> B basicMapReduce(Function<A,B> map, BinaryOperator<B> reduce, B identity, Stream<A> input){
        return input.map(map).reduce(identity, reduce);
    }
	
	
    /**
     * don't change test
     *  write map in terms of "forEach" - complete "mapInTermsOfForEach"
     */
    public static void  mapInTermsOfForEach() {
        Collection<String> result = mapInTermsOfForEach(products(), p -> p.name);
        System.out.println(result);
//        assertThat(result).containsExactly("tv","console","mouse","speakers");
    }

    // EXERCISE
    // you need to add mapped elements to result collection
    private static <A,B> Collection<B>  mapInTermsOfForEach(Stream<A> input,Function<A,B> f){
    	// A - Product , B - String
        Collection<B> result=new LinkedList<>();

        input.forEach(p -> result.add(f.apply(p)) );

        return result;
    }
	
    
    
//    /**
//     *  don't change test
//     *  write map in terms of "reduce" - complete "mapInTermsOfReduce"
//     */
//    public void mapsInTermsOfReduce() throws Exception {
//        Collection<String> result = mapInTermsOfReduce(products(), p -> p.name);
////        assertThat(result).containsExactly("tv","console","mouse","speakers");
//
//    }
//
//    // EXERCISE
//    // complete two functions which are used in stream reduce operation
//    private <A,B> Collection<B>  mapInTermsOfReduce(Stream<A> input,Function<A,B> f){
//        List<B> identity=new LinkedList<>();
//        BiFunction<List<B>,A,List<B>> accumulate=(l,e)->null;
//
//        BinaryOperator<List<B>> combine=(l1,l2)->null;
//
//        return input.reduce(identity,accumulate,combine);
//    }
    
    

	private static Stream<Product> products() {
		Product tv = new Product("tv", "300.0");
		Product console = new Product("console", "200.0");
		Product mouse = new Product("mouse", "20.0");
		Product speakers = new Product("speakers", "45.5");

		return Arrays.asList(tv, console, mouse, speakers).stream();
	}

	static class Product {
		final String name;
		final String price;

		public Product(String name, String price) {
			this.name = name;
			this.price = price;
		}
	}
}
