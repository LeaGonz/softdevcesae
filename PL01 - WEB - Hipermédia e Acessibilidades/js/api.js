// Função principal para buscar categorias de produtos
function api() {
    fetch('https://dummyjson.com/products/categories')
        .then(response => {
            if (response.ok) {
                return response.json(); // Se OK retorna o JSON
            }
        })
        .then(categories => {
            mostrarCategorias(categories); // Chamamos função para mostrar categorias
        })
        .catch(error => console.error(error));
}

// Função para mostrar as categorias na página
function mostrarCategorias(categories) {
    const categoriasCard = document.getElementById('categorias');
    categoriasCard.innerHTML = ''; // Limpamos o conteúdo do elemento

    // Ciclo para adicionar cada categoria no HTML, mostramos name
    categories.forEach(category => {
        const categoryElement = document.createElement('div');
        categoryElement.innerHTML = `
            <a class="category-link" data-category="${category.slug}">${category.name}</a>
        `;
        categoriasCard.appendChild(categoryElement);
    });

    // Evento clique para cada categoria
    document.querySelectorAll('.category-link').forEach(link => {
        link.addEventListener('click', event => {
            event.preventDefault();
            const category = event.target.getAttribute('data-category');
            cargarProdutosPorCategoria(category); // Chamamos função para buscar produtos
        });
    });
}

// Função para buscar produtos por categoria
function cargarProdutosPorCategoria(category) {
    // Criamos url com o slug do JSON anterior
    fetch(`https://dummyjson.com/products/category/${category}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            }
        })
        .then(data => {
            mostrarProdutos(data.products);
        })
        .catch(error => console.error(error));
}

// Função para mostrar os produtos na página
function mostrarProdutos(products) {
    const produtosLista = document.getElementById('produtos');
    produtosLista.innerHTML = ''; // Limpar conteúdo do elemento
    // Adicionamos um título com o nome da categoria
    const nomeCategoria = (products[0].category).toUpperCase();
    const tituloElement = document.createElement('div');
    tituloElement.className = 'card-title';
    tituloElement.innerHTML = `<h4>Produtos da categoria: ${nomeCategoria}</h4>`;
    produtosLista.appendChild(tituloElement);

    // Ciclo para adicionar cada produto no HTML
    products.forEach(product => {
        const productElement = document.createElement('div');
        productElement.className = 'card mb-3';
        productElement.innerHTML = `
            <div class="card-body">
                <h5 class="title">${product.title}</h5><br>
                <b>Price: $${product.price}</b><br>
                <b>Rating: ${product.rating}</b><br>
            </div>
        `;
        produtosLista.appendChild(productElement);
    });
}

// Chamamos a funcão principal
api();