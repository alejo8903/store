

    document.addEventListener('click', function(event) {
        const input = document.getElementById('nombre');
        const resultWrapper = document.getElementById('result-wrapper');
        const resultWrapperCustomer = document.getElementById('result-wrapper-customer');

        if (!input.contains(event.target) && !resultWrapper.contains(event.target)) {
            resultWrapper.classList.add('d-none');
            resultWrapperCustomer.classList.add('d-none');
        }
    });

    function buscarProductos() {
        const nombre = document.getElementById("nombre").value;
        fetch(`/productos/buscar?nombre=${nombre}`)
            .then(response => response.json())
            .then(data => {
                let suggested = document.getElementById("suggested-list");
                suggested.innerHTML = "";
                data.slice(0, 8).forEach(producto => {
                    let lista = document.createElement("li");
                    lista.classList.add("suggestion-item");
                    lista.innerHTML = producto.nombre;
                    lista.onclick = () => llenarDetalles(producto);
                    suggested.appendChild(lista);
                });
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

function llenarDetalles(producto) {
    console.log(producto);
    document.getElementById("productoId").value = producto.id;
    document.getElementById("nombre").value = producto.nombre;
    document.getElementById("color").value = producto.color;
    document.getElementById("disponible").value = producto.disponible === 0 ? 'No Disponible' : 'Disponible';
    document.getElementById("cantidadDisponible").value = producto.cantidadDisponible;
    document.getElementById("precioVenta").value = producto.precioVenta;
    document.getElementById("cantidad").value = 1;
    //document.getElementById("tipoFlor").value = producto.tipoFlor.nombre;
    // Limpiar las sugerencias después de seleccionar un producto
    document.getElementById("suggested-list").innerHTML = "";
}

function verificarLista() {
    const nombre = document.getElementById("nombre").value;
    let resultWrapper = document.getElementById("result-wrapper");
     if (nombre === ""){
            // Ocultar el elemento result-wrapper si el campo está vacío
        resultWrapper.classList.add("d-none");
            // document.getElementById("suggested-list").innerHTML = "";
    }else {
            // Mostrar el elemento result-wrapper si el campo no está vacío
        resultWrapper.classList.remove("d-none");
    }
}


function buscarClientes() {
        const documento = document.getElementById("documento").value;
        fetch(`/clientes/buscar?documento=${documento}`)
            .then(response => response.json())
            .then(data => {
                console.log(data);
                let suggested = document.getElementById("suggested-list-customer");
                suggested.innerHTML = "";
                data.slice(0, 5).forEach(cliente => {
                    let lista = document.createElement("li");
                    lista.classList.add("suggestion-item");
                    lista.innerHTML = cliente.documento;
                    lista.onclick = () => llenarDetallesCliente(cliente);
                    suggested.appendChild(lista);
                });
            })
            .catch(error => {
                console.error('Error:', error);
            }
        );
    }

function llenarDetallesCliente(cliente) {
    document.getElementById('clienteId').value = cliente.id;
    document.getElementById('documento').value = cliente.documento;
    document.getElementById('nombreClinete').value = cliente.nombre;
    document.getElementById('direccion').value = cliente.direccion;
    document.getElementById('telefono').value = cliente.telefono;
    document.getElementById('email').value = cliente.email;
    // Limpiar las sugerencias después de seleccionar un producto
    document.getElementById("suggested-list-customer").innerHTML = "";
}

function verificarListaCliente() {
    const documento = document.getElementById("documento").value;
    let resultWrapper = document.getElementById("result-wrapper-customer");
     if (documento === ""){
            // Ocultar el elemento result-wrapper si el campo está vacío
        resultWrapper.classList.add("d-none");
            // document.getElementById("suggested-list").innerHTML = "";
    }else {
            // Mostrar el elemento result-wrapper si el campo no está vacío
        resultWrapper.classList.remove("d-none");
    }
}


let carrito = [];

document.addEventListener('DOMContentLoaded', function() {

    document.getElementById('productForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Prevenir el comportamiento por defecto del formulario

            // Obtener los valores de los campos del formulario
        const productoId = document.getElementById("productoId").value
        const nombre = document.getElementById("nombre").value;
        const cantidad = document.getElementById("cantidad").value;
        const precioVenta = document.getElementById("precioVenta").value;

        // Crear un objeto con los datos del producto
            const producto = {
                id: productoId,
                nombre: nombre,
                cantidad: parseInt(cantidad), // Convertir a número entero
                precio: parseFloat(precioVenta) // Convertir a número decimal
            };

                // Agregar el objeto al array 'carrito'
            agregarAlCarrito(producto);
            verificarCarrito();
            crearContenProducto();

                // Imprimir el carrito en la consola para verificar
            console.log(carrito);

                // Opcional: Limpiar los campos del formulario después de agregar al carrito
            document.getElementById("productForm").reset();

            });
})

function verificarCarrito() {
    const cartCarrito = document.getElementById("card-cart")
     if (carrito.length === 0){
        cartCarrito.classList.add("d-none");
    }else {
        cartCarrito.classList.remove("d-none");
    }
}
function agregarAlCarrito(producto) {
    const precioTotalProducto = producto.precio * producto.cantidad;
    const productoExistente = carrito.find(item => item.id === producto.id);

    if (productoExistente) {
        productoExistente.cantidad += producto.cantidad;
        productoExistente.precioTotal += precioTotalProducto;
    }else {
        carrito.push({ ...producto, precioTotal: precioTotalProducto });
    }
    calcularPrecioTotalCarrito();
}

function calcularPrecioTotalCarrito() {
    let total = 0;
    carrito.forEach(producto => {
        total += producto.precioTotal;
    });
    console.log('Precio total del carrito:', total);
    return total;
}


function crearContenProducto(){
    const carritoList = document.getElementById('cart-list');
    carritoList.innerHTML = "";

    //let contenidoHTML = '';
    carrito.forEach(producto => {
         const cartDiv = `
            <div class="row mt-3">
                <div class="col-md-2">${producto.id}</div>
                <div class="col-md-2">${producto.nombre}</div>
                <div class="col-md-2">${producto.cantidad}</div>
                <div class="col-md-2">${producto.precio}</div>
                <div class="col-md-2">${producto.precioTotal}</div>
                <div class="col-md-2"><button type="button" class="btn btn-danger" onclick="removeProduct(this)">Eliminar</button></div>
            </div>
        `;

        // Concatenar cada producto en el contenedor
        carritoList.innerHTML += cartDiv;

    })
}
function removeProduct(button) {
    // Obtener el índice del producto basado en su posición en el DOM
    const row = button.parentElement.parentElement;
    const index = Array.from(row.parentElement.children).indexOf(row);

    // Eliminar
    carrito.splice(index, 1);
    verificarCarrito();
    crearContenProducto();
    calcularPrecioTotalCarrito();
}

//envio de los datos al servidor
document.addEventListener('DOMContentLoaded', function() {
    const formPedido = document.getElementById('formPedido');

    formPedido.addEventListener('submit', function(event) {
        event.preventDefault(); // Prevenir el envío por defecto del formulario

        const pedido = obtenerDatosPedido();
        // Enviar el pedido al servidor
        enviarPedidoAlServidor(pedido);
    });

    function obtenerDatosPedido() {
            const idCliente = document.getElementById('clienteId').value || null;
            const documento = document.getElementById('documento').value;
            const nombreCliente = document.getElementById('nombreClinete').value;
            const direccion = document.getElementById('direccion').value;
            const telefono = document.getElementById('telefono').value;
            const email = document.getElementById('email').value;

            const cliente = {
                id: idCliente,
                documento: documento,
                nombre: nombreCliente,
                direccion: direccion,
                telefono: telefono,
                email: email
            };

            const ocasion = document.getElementById('ocasion').value;
            const fechaEntrega = document.getElementById('FechaEntrega').value;
            const precioTotalCarrito = calcularPrecioTotalCarrito();
            const productos = carrito.map(producto => ({
                id: producto.id,
                cantidad: producto.cantidad
            }));

            const pedido = {
                cliente: cliente,
                ocasion: ocasion,
                fechaEntrega: fechaEntrega,
                precio: precioTotalCarrito,
                productos: productos //  array de carrito
            };
            console.log(pedido);
            console.log(JSON.stringify(pedido));

            return pedido;
        }
    function enviarPedidoAlServidor(pedido) {
        fetch('/pedidos/registrar', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(pedido)
        })
        .then(response => {
            if (response.ok) {
                console.log('Pedido enviado correctamente');
            } else {
                throw new Error('Error al enviar el pedido');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
    }
});