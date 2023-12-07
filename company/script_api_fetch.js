 
fetch('http://localhost:8080/empresa/sistema/rest/funcionarios/1234', {method: 'DELETE'}).
then(resposta => {
//verifica se a conexao falhou
if(!resposta.ok){
  //gera um erro que caira no catch abaixo
throw Error(resposta.status);
}
return resposta;
}).
then(jsonResposta => console.log("funcionario removido")).    //ok
catch(erro => console.log ("erro. não encontrado numat do funcionario")); // falha
