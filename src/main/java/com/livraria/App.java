package com.livraria;

import com.livraria.dao.DaoGeneric;
import com.livraria.model.Cliente;

public class App {
	
	public static void main(String[] args) {
		
		DaoGeneric<Cliente> daoGeneric = new DaoGeneric<Cliente>();
		//========= busca generica por id ==================
//		Cliente cliente = new Cliente();
//		cliente.setIdcliente(2L);
//		cliente = daoGeneric.buscarId(cliente);
//		System.out.println(cliente);
		
		//========== busca generica de todos ===============
//		List<Cliente> list = daoGeneric.BuscarTodos(Cliente.class);
//		for (Cliente cliente : list) {
//			System.out.println(cliente);
//		}
	// ===========atualização generica============ para atualizar é preciso buscar o id conforme acima
//		cliente.setNome("Pedro Ferreira do nascimento");
//		cliente = daoGeneric.atualizar(cliente);
//		System.out.println(cliente);
		
		// ======== deletar por id ==============
//		Cliente cliente = new Cliente();
//		cliente.setIdcliente(3L);
//		cliente = daoGeneric.buscarId(cliente);
//		daoGeneric.deletar(cliente);
		
		// ========== Buscar todos Clientes ===============
//		DaoCliente cliente1 = new DaoCliente();
//		cliente1.findAll().forEach(s -> System.out.println(s));
	
	}
}

