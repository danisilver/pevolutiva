package Core.Mutacion;

import Gen.Cromosoma;

interface TipoMutacion{
	Cromosoma[] mutacion(Cromosoma[] ind, double probMutacion);
}