window.onload = function() {
    console.log('Play WebSocket');
    var url = 'ws://' + window.location.hostname + ':' + window.location.port + '/JavaWeb0924/websocket/server';
    var webSocket;
    
    openBtn.addEventListener("click", function () {
        setWebSocket();
    });
    
    //設置 WebSocket
    function setWebSocket() {
        // 設定 websocket 物件
        webSocket = new WebSocket(url);
        
        // onopen , 連線成功時觸發
        webSocket.onopen = function (event) {
            console.log('連線成功');
            openBtn.disabled = true;
        };

        // onmessage , 接收到來自Server的訊息時觸發
        webSocket.onmessage = function (event) {
        };

        // onclose , 連線關閉時觸發  
        webSocket.onclose = function (event) {
        };
        
        // onerror , 連線錯誤時觸發  
        webSocket.onerror = function (event) {
        };

        
    }
}


