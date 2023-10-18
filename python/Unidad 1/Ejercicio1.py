import subprocess as sp

try:
    sp.run(["ping", "www.google.es", "-n", "10"])
except sp.CalledProcessError as e:
    print(e.output)