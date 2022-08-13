package bhat.svbneelmane.coursecatalogservice.controllers

/**
 * Dummy Controller created for testing purpose
 * @author shivaprasad-bhat
 */
import bhat.svbneelmane.coursecatalogservice.services.GreetingsService
import mu.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingsController(val greetingsService: GreetingsService) {

    companion object: KLogging()

    @GetMapping("/{name}")
    fun retrieveGreetings(@PathVariable("name") name: String): String {
        logger.info("Name is Logger..")
        return greetingsService.retrieveGreeting(name)
    }

}