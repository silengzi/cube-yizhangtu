<!-- 弹窗 -->
<template>
  <div id="popup" class="ol-popup" v-show="show">
    <dv-border-box-10 ref="popup-border-box" backgroundColor="rgb(4, 47, 84, 0.7)">
      <a href="#" id="popup-closer" class="ol-popup-closer" @click="show = false"></a>
      <div class="popup-content">
				id: {{ popup ? popup.id : "-" }} type: {{ popup ? popup.type : "-" }}
			</div>
    </dv-border-box-10>
  </div>
</template>
    
<script>
export default {
	name: "Popup",
	props: {
		popupData: {
			type: Object,
			default: () => ({})
		}
	},
	watch: {
		popupData: {
			handler(val) {
        this.$refs['popup-border-box'].initWH();
				this.show = true;
				this.popup = val;
			},
			deep: true,
			immediate: true
		}
	},
	data() {
		return {
			show: false,
			popup: null
		}
	},
	methods: {

	}
}
</script>

<style lang="less" scoped>
.ol-popup {
  position: absolute;
  // box-shadow: 0 1px 4px rgba(0, 0, 0, 0.2);
  padding: 15px;
  border-radius: 10px;
  bottom: 12px;
  left: -50px;
  min-width: 280px;
  
  /deep/ .border-box-content {
    color: #fff;
    padding: 20px;
    box-sizing: border-box;
  }
}
.ol-popup:after,
.ol-popup:before {
  top: 100%;
  border: solid transparent;
  content: " ";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
}
.ol-popup:after {
  border-top-color: white;
  border-width: 10px;
  left: 48px;
  margin-left: -10px;
}
.ol-popup:before {
  border-top-color: #cccccc;
  border-width: 11px;
  left: 48px;
  margin-left: -11px;
}
.ol-popup-closer {
  text-decoration: none;
  position: absolute;
  top: 2px;
  right: 8px;
}
.ol-popup-closer:after {
  content: "✖";
  color: "#fff"
}
.popup-content {
	min-height: 100px;
}
</style>
