<template>
  <transition name="modal">
    <div class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">

          <div class="modal-header">
            <span class="modal-default-button btn btn-secondary" @click="$emit('close')">X</span>
            <slot name="header"></slot>
          </div>

          <div class="modal-body">
            <slot name="body">

            </slot>
          </div>

          <div class="modal-footer">
            <slot name="footer">
              <button class="modal-default-button btn btn-secondary" @click="$emit('close')">
                Close
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "Modal"
}
</script>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 99999;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  width: 100%;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  transition: opacity 0.3s ease;
  overflow-y: auto;
  overflow-x: hidden;
}

.modal-wrapper {
  vertical-align: middle;
}

.modal-container {
  position: relative;
  width: 80%;
  margin: 100px auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
}

.modal-header h3 {
  margin-top: 0;
  color: #42b983;
}

.modal-header {
  display: block;
}

.modal-body {
  margin: 20px 0;
}

.modal-default-button {
  float: right;
  border-radius: 5px;
}

#keywords {
  margin-bottom: 10px;
}

#keywords li {
  display: inline-block;
  padding: 5px 10px !important;
  border-radius: 20px;
  background: var(--teal);
  color: white;
  margin-right: 5px;
  font-size: 14px;
}

.portfolio_details_inner .portfolio_right_text {
  margin-top: 15px;
}

.portfolio_details_inner .portfolio_right_text h4 {
  font-size: 20px;
   margin-bottom: 5px;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
  opacity: 0;
}

.modal-leave-active {
  opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}

</style>