

//variaveis de modal add
const fade = document.querySelector("#fade");
const modalAdd = document.querySelector("#modalAdd");
const openModalAdd = document.querySelector("#openModalAdd");
const closeModalAdd = document.querySelector("#closeModalAdd");

//variaveis de modal sair

const openModalSair = document.querySelector("#openModalSair");
const closeModalSair = document.querySelector("#closeModalSair");
const modalSair = document.querySelector("#modalSair");
const fade1 = document.querySelector("#fade1");

//modal para criar
const toggleModal = () => {
    [modalAdd, fade].forEach((el) => el.classList.toggle("hide"))
}

[openModalAdd, closeModalAdd, fade].forEach((el) => {
    el.addEventListener("click", () => toggleModal())
})
//////////////////////////////////

///modal para sair

const toggleModalSair = () => {
    modalSair.classList.toggle("hide");
    fade1.classList.toggle("hide1")
}

[openModalSair, closeModalSair, fade1].forEach((el) => {
    el.addEventListener("click", () => toggleModalSair())
})

//variaveis de modal editar
///const openModalEditar = document.querySelectorAll(".openModalEditar");
//const closeModalEditar = document.querySelector("#closeModalEditar");
//const modalEditar = document.querySelector("#modalEditar");
//const fade2 = document.querySelector("#fade2");



//const toggleModalEditar = () => {
   /// modalEditar.classList.toggle("hide");
   // fade2.classList.toggle("hide2");
//};

//[openModalEditar, closeModalEditar, fade2].forEach((el) => {
 //   el.addEventListener("click", () => toggleModalEditar());
//});



















