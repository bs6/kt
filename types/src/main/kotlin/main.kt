package types;
fun main(args: Array<String>) {
	// Unit:
	val unit = Unit
	val unit2 = Unit
	println(unit::class)
	println("Unit equals to itself? " + (unit == unit2)) // true
	println("Unit === to itself? " + (unit === unit2)) // true
	
	val unit3: Unit? = null // Unit be Unit?
	println("Null is a valid value of Unit? " + unit3) // sure why not :)
	// would not compile: println(unit3::class)
	// would not execute: println(unit3!!::class)
	
    // Nothing:
	// would not compile: val nothing = Nothing // Actually defined as "public final class Nothing private constructor() {}"
	// however:
	val nothing: Nothing? = null
	println("Null is a valid value of Nothing? " + nothing) // sure why not :)
	println("Null of nothing and null of unit are equlable? " + (unit3 == nothing)) // true
	println("Null of nothing and null of unit are ===? " + (unit3 === nothing)) // true
	
	// Boolean:
	val t = true
	val f = false
    println("Some results: " + (t || f) + (t && f) + (t && f.not()) + (t or f) + f.or(t))
	// NOTE: contrary to Java & and | would not apply
	
	// Int:
	// let's define some function:
	fun fibo(n: Int): Int {
		if (n < 0) {
			throw IllegalArgumentException()
		}
		if (n == 0) {
			return 1
		}
		if (n == 1) {
			return 1
		}
		return fibo(n - 1) + fibo(n - 2)
	}
	
	var i1 = fibo(5)
	var i2 = fibo(6) - 5
	println("Int: Equal? " + (i1 == i2))
	println("Int: ===? " + (i1 === i2))
	var a1: Any = fibo(5)
	var a2: Any = fibo(6) - 5
	println("Int (as Any): Equal? " + (a1 == a2))
	println("Int (as Any): ===? " + (a1 === a2)) // true just by chance (Java cached boxing type)
	a1 = fibo(18)
	a2 = fibo(18)
	println("bigger Int (as Any): Equal? " + (a1 == a2))
	println("bigger Int (as Any): ===? " + (a1 === a2) + " <---- and this may surprise") // false!
	
	var I1: Int? = fibo(18)
	var I2: Int? = fibo(18)
	println("bigger Int?: Equal? " + (I1 == I2))
	println("bigger Int?: ===? " + (I1 === I2) + " <---- and this may surprise") // now true!

}