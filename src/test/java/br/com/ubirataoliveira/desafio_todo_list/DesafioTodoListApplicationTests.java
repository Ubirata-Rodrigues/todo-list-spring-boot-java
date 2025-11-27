package br.com.ubirataoliveira.desafio_todo_list;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.ubirataoliveira.desafio_todo_list.entity.Todo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class DesafioTodoListApplicationTests {
	@Autowired
	private WebTestClient webTestClient;

    
    //Create
	@Test
	void textCreateTodoSucess() {
		var todo = new Todo("Criação de Teste", "Test Create", 1, false);

		webTestClient
			.post()
			.uri("/todo")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$[0].realizado").isEqualTo(todo.isRealizado())
			.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void textCreateTodoFailure() {

		webTestClient
			.post()
			.uri("/todo")
			.bodyValue(
				new Todo("", "", 1, false)
			)
			.exchange()
			.expectStatus().isBadRequest();
	}

	// Update
    @Test
    void testUpdateTodoSuccess() {
        textCreateTodoSucess();
        
        Long id = webTestClient
            .get()
            .uri("/todo")
            .exchange()
            .expectBodyList(Todo.class)
            .returnResult()
            .getResponseBody()
            .get(0).getId();
        
        var todoAtualizado = new Todo("Atualizado", "Nova Descrição", 3, true);
        todoAtualizado.setId(id);
        
        webTestClient
            .put()
            .uri("/todo")
            .bodyValue(todoAtualizado)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$").isArray()
            .jsonPath("$[0].nome").isEqualTo(todoAtualizado.getNome())
            .jsonPath("$[0].descricao").isEqualTo(todoAtualizado.getDescricao())
            .jsonPath("$[0].realizado").isEqualTo(todoAtualizado.isRealizado())
            .jsonPath("$[0].prioridade").isEqualTo(todoAtualizado.getPrioridade());
}

    @Test
    void testUpdateTodoFailure() {
        textCreateTodoSucess();
        
        Long id = webTestClient
            .get()
            .uri("/todo")
            .exchange()
            .expectBodyList(Todo.class)
            .returnResult()
            .getResponseBody()
            .get(0).getId();
        
        var todoInvalido = new Todo("", "", 1, false);
        todoInvalido.setId(id);
        
        webTestClient
            .put()
            .uri("/todo")
            .bodyValue(todoInvalido)
            .exchange()
            .expectStatus().is5xxServerError();
    }

    // Delete
    @Test
    void testDeleteTodoSuccess() {
        textCreateTodoSucess();
        
        Long id = webTestClient
            .get()
            .uri("/todo")
            .exchange()
            .expectBodyList(Todo.class)
            .returnResult()
            .getResponseBody()
            .get(0).getId();
        
        webTestClient
            .delete()
            .uri("/todo/" + id)
            .exchange()
            .expectStatus().isOk()
            .expectBody()
            .jsonPath("$").isArray()
            .jsonPath("$.length()").isEqualTo(0);
    }

    @Test
    void testDeleteTodoFailure() {
        webTestClient
            .delete()
            .uri("/todo/999999")
            .exchange()
            .expectStatus().isNotFound();
    }

}
