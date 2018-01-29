var myttshop = {

    registerMenu: function () {
        var _this = this;
        $('#menu .easyui-tree').tree({
            onClick:function (node) {
                var title = node.text;
                var href = node.attributes.href;
                _this.addTab(title,href);
            }
        });
    },
    addTab: function (title, href) {
        if ($('#tab').tabs('exists', title)) {
            $('#tab').tabs('select',title);
        } else {
            $('#tab').tabs('add', {
                title: title,
                href: href,
                closable: true
            });
        }

    },
    closeTab: function (title) {
        $('#tab').tabs('close', title);
    }
}