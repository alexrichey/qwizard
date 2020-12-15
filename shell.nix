with import <nixpkgs> {};

stdenv.mkDerivation {
    name = "cljs";
    buildInputs = [
        nodejs
        leiningen
        clojure
        openjdk
    ];
    shellHook = ''
        export PATH="$PWD/node_modules/.bin/:$PATH";
    '';
}
