if (process.env.NODE_ENV === "production") {
    const opt = require("./scalajs-react-example-opt.js");
    opt.main();
    module.exports = opt;
} else {
    var exports = window;
    exports.require = require("./scalajs-react-example-fastopt-entrypoint.js").require;
    window.global = window;

    const fastOpt = require("./scalajs-react-example-fastopt.js");
    fastOpt.main()
    module.exports = fastOpt;

    if (module.hot) {
        module.hot.accept();
    }
}
