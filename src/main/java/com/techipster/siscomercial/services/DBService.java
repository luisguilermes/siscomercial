package com.techipster.siscomercial.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techipster.siscomercial.domain.Categoria;
import com.techipster.siscomercial.domain.Cidade;
import com.techipster.siscomercial.domain.Cliente;
import com.techipster.siscomercial.domain.Endereco;
import com.techipster.siscomercial.domain.Estado;
import com.techipster.siscomercial.domain.ItemPedido;
import com.techipster.siscomercial.domain.Pagamento;
import com.techipster.siscomercial.domain.PagamentoComBoleto;
import com.techipster.siscomercial.domain.PagamentoComCartao;
import com.techipster.siscomercial.domain.Pedido;
import com.techipster.siscomercial.domain.Produto;
import com.techipster.siscomercial.domain.enums.EstadoPagamento;
import com.techipster.siscomercial.domain.enums.TipoCliente;
import com.techipster.siscomercial.repositories.CategoriaRepository;
import com.techipster.siscomercial.repositories.CidadeRepository;
import com.techipster.siscomercial.repositories.ClienteRepository;
import com.techipster.siscomercial.repositories.EnderecoRepository;
import com.techipster.siscomercial.repositories.EstadoRepository;
import com.techipster.siscomercial.repositories.ItemPedidoRepository;
import com.techipster.siscomercial.repositories.PagamentoRepository;
import com.techipster.siscomercial.repositories.PedidoRepository;
import com.techipster.siscomercial.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoReposistory;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public void instantiateTestDatabase() throws ParseException {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto po1 = new Produto(null, "Computador", 2000.00);
		Produto po2 = new Produto(null, "Impressora", 800.00);
		Produto po3 = new Produto(null, "Mouse", 80.00);
		Produto po4 = new Produto(null, "Mesa de Escritório", 300.00);
		Produto po5 = new Produto(null, "Toalha", 50.00);
		Produto po6 = new Produto(null, "Colcha", 200.00);
		Produto po7 = new Produto(null, "TV true color", 1200.00);
		Produto po8 = new Produto(null, "Roçadeira", 800.00);
		Produto po9 = new Produto(null, "Abajour", 100.00);
		Produto po10 = new Produto(null, "Pendente", 180.00);
		Produto po11 = new Produto(null, "Shampoo", 90.00);

		cat1.getProdutos().addAll(Arrays.asList(po1, po2, po3));
		cat2.getProdutos().addAll(Arrays.asList(po2, po4));
		cat3.getProdutos().addAll(Arrays.asList(po5, po6));
		cat4.getProdutos().addAll(Arrays.asList(po1, po2, po3, po7));
		cat5.getProdutos().addAll(Arrays.asList(po8));
		cat6.getProdutos().addAll(Arrays.asList(po9, po10));
		cat7.getProdutos().addAll(Arrays.asList(po11));

		po1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		po2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		po3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		po4.getCategorias().addAll(Arrays.asList(cat2));
		po5.getCategorias().addAll(Arrays.asList(cat3));
		po6.getCategorias().addAll(Arrays.asList(cat3));
		po7.getCategorias().addAll(Arrays.asList(cat4));
		po8.getCategorias().addAll(Arrays.asList(cat5));
		po9.getCategorias().addAll(Arrays.asList(cat6));
		po10.getCategorias().addAll(Arrays.asList(cat6));
		po11.getCategorias().addAll(Arrays.asList(cat7));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));
		produtoRepository.saveAll(Arrays.asList(po1, po2, po3, po4, po5, po6, po7, po8, po9, po10, po11));

		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Belo Horizonte", e1);
		Cidade c2 = new Cidade(null, "Campinas", e2);
		Cidade c3 = new Cidade(null, "São Paulo", e2);

		e1.getCidades().addAll(Arrays.asList(c1));
		e1.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("3133815697", "3199948764"));

		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco end2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "37229831", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, end2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoReposistory.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, po1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, po3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, po2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		po1.getItens().addAll(Arrays.asList(ip1));
		po2.getItens().addAll(Arrays.asList(ip3));
		po3.getItens().addAll(Arrays.asList(ip2));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
	}

}
