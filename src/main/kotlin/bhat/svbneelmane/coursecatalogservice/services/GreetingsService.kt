package bhat.svbneelmane.coursecatalogservice.services
/**
 * Dummy Service file created for testing purpose
 * @author shivaprasad-bhat
 */
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {

    @Value("\${message}")
    lateinit var message: String

    fun retrieveGreeting(name: String) = "$name, $message"
}