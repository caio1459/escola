package com.unialfa.escola.service;

import com.unialfa.escola.model.Aluno;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AlunoService {
    private List<Aluno> alunos = new ArrayList<>();//declara uma variável de
    // instância privada chamada "alunos" que é uma lista de objetos do tipo "Aluno"

    public void salvar(Aluno aluno){
        aluno.setDataCadastro(LocalDateTime.now());// método "now" da classe "LocalDateTime" pega a data e hora atual
        if (Objects.isNull(aluno.getId())){//Verifica se o id passado no form é nulo atráves do método "isNull"
            //Se o ID for nulo, significa que o aluno é novo e ainda não foi adicionado à lista.
            var novoId = Integer.valueOf(alunos.size() + 1);//define um novo ID para o aluno adicionando 1 ao tamanho atual da lista de alunos e atribuindo o novo ID ao aluno recebido
            aluno.setId(novoId);
            alunos.add(aluno);//adiciona o aluno atualizado à lista de alunoss usando o método "add" da classe "List".
        }else {//Se o ID do aluno não for nulo a lista é atualizada
            var index = alunos.indexOf(aluno);//o método procura o índice do aluno na lista de alunos usando o método "indexOf" da classe "List"
            alunos.get(index).setNome(aluno.getNome());//em seguida, atualiza o nome do aluno na lista usando o método "setNome" da classe "Alumo".
        }
    }
    public List<Aluno> listar(){
        return alunos;//retorna a lista de alunos existente na classe para ser usada em outras partes do programa.
    }
    public Aluno buscarId(Integer id) {//Esse método é responsável por buscar um aluno na lista de alunos pelo seu ID.
        var aluno = new Aluno();//é criada uma nova instância da classe Aluno chamada aluno.
        aluno.setId(id);//é definido o ID do objeto aluno criado para o valor recebido no parâmetro id.

        var index = alunos.indexOf(aluno);//o método indexOf da lista de alunos para encontrar o índice da primeira ocorrência do objeto aluno na lista.
        if (index < 0) return null;// Caso o objeto aluno não seja encontrado, o método retorna null.
        return alunos.get(index);//se o objeto aluno for encontrado na lista de alunos, o método utiliza o método get da lista de alunos para retornar o objeto Aluno correspondente ao índice encontrado.
        // O objeto é então retornado pelo método.
    }
    public void alterar(int index, Aluno aluno){
        alunos.get(index).setId(aluno.getId());
        alunos.get(index).setNome(aluno.getNome());
        alunos.get(index).setEndereco(aluno.getEndereco());
    }
    public void remover(Aluno aluno){
        alunos.remove(aluno);//remove o aluno da lista
    }
}
