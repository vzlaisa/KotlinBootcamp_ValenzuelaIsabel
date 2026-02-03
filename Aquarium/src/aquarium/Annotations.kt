package aquarium
import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false
}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
    val classObj = Plant::class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name)
    }

    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    val annotated: ImAPlant? = classObj.findAnnotation<ImAPlant>()
    annotated.apply {
        println("Found a plant annotation")
    }
}