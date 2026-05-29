package com.techshrines.composefirstdemo.learning.collections

class CollectionTest {
    /**
     * You can edit, run, and share this code.
     * play.kotlinlang.org
     */
    fun main() {
        val data = listOf(
            listOf(1,2,3),
            listOf(4,5,6)
        )
        val result = data.flatMap{
            it
        }
        //println(result) //[1, 2, 3, 4, 5, 6]

        data class User(
            val name: String,
            val skills: List<String>
        )
        val users = listOf(
            User("Chetan", listOf("Kotlin", "Java","Flutter")),
            User("Rahul", listOf("Flutter", "Dart"))
        )

        val allSkills = users.flatMap {
            it.skills
        }

//println(allSkills) //[Kotlin, Java, Flutter, Dart]

        val setA = setOf(1, 2, 3)
        val setB = setOf(3, 4, 5)

        // Check existence
        //  println(setA.contains(2)) // true

        // Set math
        val combined = setA.union(setB)       // Result: [1, 2, 3, 4, 5]
        val overlapping = setA.intersect(setB) // Result: [3]
//println(combined) //[1, 2, 3, 4, 5]
//println(overlapping) //[3]
//println(setA) //[1, 2, 3]
//println(setB) //[3, 4, 5]

        val team = listOf(
            Employee("Alice", "Engineering"),
            Employee("Bob", "HR"),
            Employee("Charlie", "Engineering"),
            Employee("Diana", "HR")
        )

        // Grouping employees by their department
        val departmentMap: Map<String, List<Employee>> = team.groupBy { it.department }

        // println(departmentMap) //{Engineering=[Employee(name=Alice, department=Engineering), Employee(name=Charlie, department=Engineering)], HR=[Employee(name=Bob, department=HR), Employee(name=Diana, department=HR)]}


        val products = listOf(
            Product("P101", "Laptop", 999.99),
            Product("P102", "Phone", 499.99),
            Product("P103", "Mouse", 25.00),
            Product("P103", "Keyboard", 125.00)
        )

        // Turn the list into an ID lookup map
        val productLookup: Map<String, Product> = products.associateBy { it.id }
        //println(productLookup) //{P101=Product(id=P101, name=Laptop, price=999.99), P102=Product(id=P102, name=Phone, price=499.99), P103=Product(id=P103, name=Keyboard, price=125.0)}
        // Look up a product instantly without searching the whole list
        val product = productLookup["P103"]
        //println(product) //Product(id=P103, name=Keyboard, price=125.0)

        val names = listOf("Alice", "Bob", "Charlie")
        val scores = listOf(95, 88, 92, 100) // 100 will be ignored

        // Merging into a list of Pairs
        val playerResults: List<Pair<String, Int>> = names.zip(scores)
        println(playerResults)
        // Output: [(Alice, 95), (Bob, 88), (Charlie, 92)]

        // Pro-Tip: You can transform the pairs instantly using a lambda block
        val announcements = names.zip(scores) { name, score -> "$name scored $score!" }
        //  println(announcements)
        // Output: [Alice scored 95!, Bob scored 88!, Charlie scored 92!]

        val sum = listOf(1,2,3).reduce { acc, i ->
            acc + i
        }
        //   println(sum)
        val list = listOf(1,2,3)

// println(list.any { it > 2 })
// println(list.all { it > 0 })
// println(list.none { it > 5 })

        val result1 = (1..10).toList().chunked(3)
//println(result1)//[[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]

        val result2 = listOf(1,2,3,4,5)
            .windowed(3)
// println(result2) //[[1, 2, 3], [2, 3, 4], [3, 4, 5]]

        val result3 = listOf(1,2,3,4)
            .partition {
                it % 2 == 0
            }

// println(result3.first) //[2,4]
// println(result3.second)//[1, 3]
        val numbers = listOf(1,2,3,4,5)

// println(numbers.take(2)) //[1, 2]
// println(numbers.drop(2)) //[3, 4, 5]
    }
    data class Product(val id: String, val name: String, val price: Double)
    data class Employee(val name: String, val department: String)
}